package com.zz.HttpClient.Bean.Sys;

import java.io.Serializable;

/**
 * 
 * @Title:Principal
 * @Description:TODO(授权用户信息)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月10日 上午11:46:19
 */
public class Principal implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id; 				// 编号
	private String loginName; 		// 登录名
	private String name; 			// 姓名
	private boolean mobileLogin; 	// 是否手机登录
	
	public Principal() {
		super();
	}
	
	public Principal(String id, String loginName, String name, boolean mobileLogin) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.name = name;
		this.mobileLogin = mobileLogin;
	}

	public Principal(User user, boolean mobileLogin) {
		this.id = user.getId();
		this.loginName = user.getLoginName();
		this.name = user.getName();
		this.mobileLogin = mobileLogin;
	}

	public String getId() {
		return id;
	}

	public String getLoginName() {
		return loginName;
	}

	public String getName() {
		return name;
	}

	public boolean isMobileLogin() {
		return mobileLogin;
	}

	@Override
	public String toString() {
		return id;
	}

}