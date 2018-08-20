package com.zz.HttpClient.Util;

import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zz.HttpClient.Bean.Sys.Menu;
import com.zz.HttpClient.Bean.Sys.Principal;
import com.zz.HttpClient.Bean.Sys.Role;
import com.zz.HttpClient.Bean.Sys.User;
import com.zz.HttpClient.Dao.UserDao;
import com.zz.HttpClient.Service.sys.MenuService;
import com.zz.HttpClient.Service.sys.RoleService;

/**
 * 
 * @Title:UserUtils
 * @Description:TODO(用户工具类)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月10日 上午11:50:03
 */
@Component
public class UserUtils {

	public static final String USER_CACHE = "userCache";
	public static final String USER_CACHE_ID_ = "id_";
	public static final String USER_CACHE_LOGIN_NAME_ = "ln";
	public static final String USER_CACHE_LIST_BY_OFFICE_ID_ = "oid_";
	
	public static final String CACHE_AUTH_INFO = "authInfo";
	public static final String CACHE_ROLE_LIST = "roleList";
	public static final String CACHE_MENU_LIST = "menuList";
	public static final String CACHE_AREA_LIST = "areaList";
	public static final String CACHE_OFFICE_LIST = "officeList";
	public static final String CACHE_OFFICE_ALL_LIST = "officeAllList";
	
	@Autowired
	private SessionDAO sessionDAO;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private MenuService menuService;
	
	public static UserUtils userUtils;
	
	@PostConstruct
	public void init() {
		userUtils = this;
	}
	
	/**
	 * 根据ID获取用户
	 * @param id
	 * @return 取不到返回null
	 */
	public static User get(String id){
		User user = userUtils.userDao.get(id);
		if (user == null){
			return null;
		}
		return user;
	}
	
	/**
	 * 
	 * @Title：getByLoginName
	 * @Description: TODO(根据登录名获取用户)
	 * @see：
	 * @param loginName
	 * @return
	 */
	public static User getByLoginName(String loginName){
		User user = userUtils.userDao.getByLoginName(new User(null, loginName));
		if (user == null){
			return null;
		}
		return user;
	}
	
	/**
	 * 
	 * @Title：getRoleByUser
	 * @Description: TODO(根据用户查询角色)
	 * @see：
	 * @param user
	 * @return
	 */
	public static List<Role> getRoleByUser(User user) {
		if (user.isAdmin()){
			return userUtils.roleService.findAllList(new Role());
		}
		return userUtils.roleService.getRoleByUser(new Role(user));
	}
	
	public static List<Role> getRoleByUser(Principal principal) {
		if (principal.isAdmin()) {
			return userUtils.roleService.findAllList(new Role());
		}
		return userUtils.roleService.getRoleByUser(new Role(principal));
	}
	
	/**
	 * 
	 * @Title：getMenuList
	 * @Description: TODO(获取用户授权树形菜单)
	 * @see：
	 * @return
	 */
	public static List<Menu> getTreeMenusByUser(Principal principal) {
		if (principal.isAdmin()) {
			return userUtils.menuService.getAllTreeMenus(new Menu(principal));
		}
		return userUtils.menuService.getTreeMenus(new Menu(principal));
	}
	
	/**
	 * 
	 * @Title：getMenuList
	 * @Description: TODO(获取用户授权左侧菜单)
	 * @see：
	 * @return
	 */
	public static List<Menu> getMenuListByUser(String parentId) {
		Principal principal = getPrincipal();
		if (principal.isAdmin()) {
			return userUtils.menuService.getAllMenuList(new Menu(principal, parentId));
		}
		return userUtils.menuService.getMenuList(new Menu(principal, parentId));
	}
	
	/**
	 * 
	 * @Title：getUser
	 * @Description: TODO(获取当前用户)
	 * @see：
	 * @return
	 */
	public static User getUser(){
		Principal principal = getPrincipal();
		if (principal!=null){
			User user = get(principal.getId());
			if (user != null){
				return user;
			}
			return new User();
		}
		// 如果没有登录，则返回实例化空的User对象。
		return new User();
	}
	
	/**
	 * 
	 * @Title：getSubject
	 * @Description: TODO(获取授权主要对象)
	 * @see：
	 * @return
	 */
	public static Subject getSubject(){
		return SecurityUtils.getSubject();
	}
	
	/**
	 * 
	 * @Title：getPrincipal
	 * @Description: TODO(获取当前登录者对象)
	 * @see：
	 * @return
	 */
	public static Principal getPrincipal(){
		try{
			Subject subject = SecurityUtils.getSubject();
			Principal principal = (Principal) subject.getPrincipal();
			if (principal != null){
				return principal;
			}
		}catch (UnavailableSecurityManagerException e) {
			
		}catch (InvalidSessionException e){
			
		}
		return null;
	}
	
	/**
	 * 
	 * @Title：getSession
	 * @Description: TODO(获取session)
	 * @see：
	 * @return
	 */
	public static Session getSession(){
		try{
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession(false);
			if (session == null){
				session = subject.getSession();
			}
			if (session != null){
				return session;
			}
		}catch (InvalidSessionException e){
			
		}
		return null;
	}
	
	/**
	 * 
	 * @Title：kickOutUser
	 * @Description: TODO((踢除指定用户)
	 * @see：
	 * @param id 用户编号
	 */
	public static void kickOutUser(String id) {
	   	// 踢出此账号在线用户
    	Collection<Session> sessions = userUtils.sessionDAO.getActiveSessions();
    	for(Session session : sessions) {
    		Object obj = session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
            if (!ObjectUtils.isEmpty(obj)) {
                Principal principal = (Principal) ((SimplePrincipalCollection) obj).getPrimaryPrincipal();
                if (id.equalsIgnoreCase(principal.getId())
                		&& !UserUtils.getSession().getId().equals(session.getId())) {
                	Logs.info("踢出用户：" + session.getId());
                	userUtils.sessionDAO.delete(session);
				}
    		}
    	}
	}
	
	/** 
	 * 用 session 代替缓存，从读取速度上来说 session 远比缓存快，
	 * 但 session 是一次性的。退出后 session 失效；
	 * 而缓存只要项目不重启就存在；
	 * */
	public static Object getCache(String key) {
		return getCache(key, null);
	}
	
	public static Object getCache(String key, Object defaultValue) {
		Object obj = getSession().getAttribute(key);
		return obj==null?defaultValue:obj;
	}

	public static void putCache(String key, Object value) {
		getSession().setAttribute(key, value);
	}

	public static void removeCache(String key) {
		getSession().removeAttribute(key);
	}
	
	public static void clearCache() {
		userUtils.roleService.clearCache();
	}
	
}
