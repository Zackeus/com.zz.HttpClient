package com.zz.HttpClient.modules.sys.dao;

import java.util.List;

import com.zz.HttpClient.common.annotation.MyBatisDao;
import com.zz.HttpClient.common.dao.CrudDao;
import com.zz.HttpClient.modules.sys.entity.Menu;

/**
 * 
 * @Title:MenuDao
 * @Description:TODO(菜单DAO接口)
 * @Company:
 * @author zhou.zhang
 * @date 2018年8月14日 上午11:06:55
 */
@MyBatisDao
public interface MenuDao extends CrudDao<Menu> {
	
	public List<Menu> getAllTreeMenus(Menu menu);
	
	public List<Menu> getTreeMenus(Menu menu);
	
	public List<Menu> getAllMenuList(Menu menu);

	public List<Menu> getMenuList(Menu menu);
	
	public Integer getMaxSortById(String id);
	
}
