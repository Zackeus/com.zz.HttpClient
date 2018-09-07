package com.zz.HttpClient.modules.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zz.HttpClient.common.service.CrudService;
import com.zz.HttpClient.common.utils.ObjectUtils;
import com.zz.HttpClient.modules.sys.dao.MenuDao;
import com.zz.HttpClient.modules.sys.entity.Menu;

/**
 * 
 * @Title:MenuService
 * @Description:TODO(菜单Service)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月15日 下午12:38:26
 */
@Service("menuService")
public class MenuService extends CrudService<MenuDao, Menu> {
	
	@Autowired
	private MenuDao menuDao;
	
	/**
	 * 
	 * @Title：getMneuByParentId
	 * @Description: TODO(根据Id查询菜单)
	 * @see：
	 * @param parentid
	 * @return 
	 */
	@Cacheable(value = {"sysMenuCache"}, keyGenerator = "cacheKeyGenerator")
	@Override
	public Menu get(String id) {
		return menuDao.get(id);
	}
	
	/**
	 * 
	 * @Title：getMaxSortById
	 * @Description: TODO(根据 id 查询子菜单最大最大排序值)
	 * @see：
	 * @param id
	 * @return
	 */
	@Cacheable(value = {"sysMenuCache"}, keyGenerator = "cacheKeyGenerator")
	public Integer getMaxSortById(String id) {
		return menuDao.getMaxSortById(id);
	}

	/**
	 * 
	 * @Title：findAllList
	 * @Description: TODO(获取全部菜单列表（父子菜单不嵌套）)
	 * @see：
	 * @param menu
	 * @return
	 */
	@Cacheable(value = {"sysMenuCache"}, keyGenerator = "cacheKeyGenerator")
	public List<Menu> findAllList() {
		return menuDao.findAllList();
	}
	
	/**
	 * 
	 * @Title：getAllTreeMenus
	 * @Description: TODO(获取全部一级菜单)
	 * @see：
	 * @param menu
	 * @return
	 */
	@Cacheable(value = {"sysMenuCache"}, keyGenerator = "cacheKeyGenerator")
	public List<Menu> getAllTreeMenus(Menu menu) {
		return menuDao.getAllTreeMenus(menu);
	}
	
	/**
	 * 
	 * @Title：getTreeMenus
	 * @Description: TODO(根据用户权限查询一级菜单)
	 * @see：
	 * @param menu
	 * @return
	 */
	@Cacheable(value = {"sysMenuCache"}, keyGenerator = "cacheKeyGenerator")
	public List<Menu> getTreeMenus(Menu menu) {
		return menuDao.getTreeMenus(menu);
	}
	
	/**
	 * 
	 * @Title：getAllMenuList
	 * @Description: TODO(根据父级标识获取全部子菜单列表（父子菜单嵌套）)
	 * @see：此方法不能使用缓存，因开启了懒加载模式，开启缓存可能会使嵌套查询不执行
	 * @param menu
	 * @return
	 */
	public List<Menu> getAllMenuList(Menu menu) {
		return menuDao.getAllMenuList(menu);
	}
	
	/**
	 * 
	 * @Title：getMenuList
	 * @Description: TODO(通过用户权限根据父级标识查询子菜单列表)
	 * @see：
	 * @param menu
	 * @return
	 */
	@Cacheable(value = {"sysMenuCache"}, keyGenerator = "cacheKeyGenerator")
	public List<Menu> getMenuList(Menu menu) {
		return menuDao.getMenuList(menu);
	}
	
	/**
	 * 
	 * @Title：save
	 * @Description: TODO(菜单添加和更新)
	 * @see：
	 * @param menu
	 * @return
	 */
	@CacheEvict(value = {"sysMenuCache"}, allEntries = true, beforeInvocation = true)
	@Override
	public void save(Menu entity) {
		super.save(entity);
	}
	
	/**
	 * 
	 * @Title：delete
	 * @Description: TODO(删除菜单)
	 * @see：
	 * @param menu
	 * @return
	 */
	@CacheEvict(value = {"sysMenuCache"}, allEntries = true, beforeInvocation = true)
	@Override
	public void delete(Menu entity) {
		Menu menu = get(entity.getId());
		List<Menu> childrens = getAllMenuList(menu);
		super.delete(entity);
		
		if (!ObjectUtils.isEmpty(childrens)) {
			for (Menu childMenu : childrens) {
	            if (ObjectUtils.isEmpty(childMenu.getChildren())) {
	            	super.delete(childMenu);
	            } else {
	                //递归删除节点
	                this.delete(childMenu);
	            }
	        }
		} 
	}
	
}
