package com.zz.HttpClient.modules.sys.dao;

import com.zz.HttpClient.common.annotation.MyBatisDao;
import com.zz.HttpClient.common.dao.CrudDao;
import com.zz.HttpClient.modules.sys.entity.User;

/**
 * 
 * @Title:UserDao
 * @Description:TODO(用户DAO接口)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月13日 下午4:14:30
 */
@MyBatisDao
public interface UserDao extends CrudDao<User> {
	
	public User getByLoginName(User user);

}
