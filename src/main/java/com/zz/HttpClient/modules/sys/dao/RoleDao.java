package com.zz.HttpClient.modules.sys.dao;

import java.util.List;

import com.zz.HttpClient.common.annotation.MyBatisDao;
import com.zz.HttpClient.common.dao.CrudDao;
import com.zz.HttpClient.modules.sys.entity.Role;

/**
 * 
 * @Title:RoleDao
 * @Description:TODO(角色DAO接口)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月13日 下午4:23:08
 */
@MyBatisDao
public interface RoleDao extends CrudDao<Role> {
	
	public List<Role> getRoleByUser(Role role);

}
