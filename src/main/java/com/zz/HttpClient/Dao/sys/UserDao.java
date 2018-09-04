package com.zz.HttpClient.Dao.sys;

import com.zz.HttpClient.Bean.Sys.User;
import com.zz.HttpClient.Dao.Basic.CrudDao;

/**
 * 
 * @Title:UserDao
 * @Description:TODO(用户DAO接口)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月13日 下午4:14:30
 */
public interface UserDao extends CrudDao<User> {
	
	public User getByLoginName(User user);

}
