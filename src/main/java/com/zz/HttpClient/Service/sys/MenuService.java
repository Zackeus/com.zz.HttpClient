package com.zz.HttpClient.Service.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zz.HttpClient.Bean.Sys.Menu;
import com.zz.HttpClient.Dao.sys.MenuDao;
import com.zz.HttpClient.Service.Basic.CrudService;
import com.zz.HttpClient.Util.Logs;

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
	
	@Cacheable(value = {"sysMenuCache"})
	public List<Menu> getTreeMenus() {
		return menuDao.getTreeMenus();
	}
	
	@Cacheable(value = {"sysMenuCache"})
	public List<Menu> getMenuList(String parentId) {
		return menuDao.getMenuList(parentId);
	}
	
	@CacheEvict(value = {"sysMenuCache"},allEntries = true)
	public void clearCache() {
		Logs.info("清除菜单缓存.......");
	}
	
}
