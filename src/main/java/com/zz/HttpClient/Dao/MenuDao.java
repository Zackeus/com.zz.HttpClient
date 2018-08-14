package com.zz.HttpClient.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;

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
	
	@Cacheable(value = {"sysMenuCache"})
	public List<Menu> getTreeMenus();
	
	@Cacheable(value = {"sysMenuCache"})
	public List<Menu> getMenuList(@Param("parentId") String parentId);

}
