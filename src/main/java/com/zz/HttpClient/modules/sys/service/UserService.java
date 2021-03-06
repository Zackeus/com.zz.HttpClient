package com.zz.HttpClient.modules.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz.HttpClient.common.service.CrudService;
import com.zz.HttpClient.modules.sys.dao.UserDao;
import com.zz.HttpClient.modules.sys.entity.User;

/**
 * 
 * @Title:UserService
 * @Description:TODO(用户Service)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年9月4日 下午4:06:33
 */
@Service("userService")
public class UserService extends CrudService<UserDao, User> {
	
	@Autowired
	private UserDao userDao;
	
	/**
	 * 
	 * @Title：getByLoginName
	 * @Description: TODO(根据登录名称查询用户)
	 * @see：
	 * @param user
	 * @return
	 */
	public User getByLoginName(User user) {
		return userDao.getByLoginName(user);
	}

}
