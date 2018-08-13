package com.zz.HttpClient.Util;

import javax.annotation.PostConstruct;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zz.HttpClient.Bean.Sys.Principal;
import com.zz.HttpClient.Bean.Sys.Role;
import com.zz.HttpClient.Bean.Sys.User;
import com.zz.HttpClient.Dao.RoleDao;
import com.zz.HttpClient.Dao.UserDao;

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
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	public static UserUtils userUtils;
	
	@PostConstruct
	public void init() {
		userUtils = this;
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
		user.setRoleList(userUtils.roleDao.findList(new Role(user)));
		return user;
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
			Principal principal = (Principal)subject.getPrincipal();
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
	
}
