package com.zz.HttpClient.Dao.sys;

import java.util.List;

import com.zz.HttpClient.Bean.Sys.Menu;
import com.zz.HttpClient.Dao.Basic.CrudDao;

/**
 * 
 * @Title:MenuDao
 * @Description:TODO(菜单DAO接口)
 * @Company:
 * @author zhou.zhang
 * @date 2018年8月14日 上午11:06:55
 */
public interface MenuDao extends CrudDao<Menu> {
	
	public List<Menu> getAllTreeMenus(Menu menu);

	public List<Menu> getTreeMenus(Menu menu);

	public List<Menu> getMenuList(Menu menu);
	
}
