package com.zz.HttpClient.Shiro;

import org.apache.shiro.session.Session;
import com.zz.HttpClient.Util.Logs;

/**
 * Shiro session监听
 * 
 * @author zhou.zhang
 *
 */
public class SessionListener implements org.apache.shiro.session.SessionListener {

	/**
	 * 会话创建触发 已进入shiro的过滤连就触发这个方法
	 */
	@Override
	public void onStart(Session session) {
		Logs.info(session.getId() + ": 会话创建");
	}

	/**
	 * 退出会话
	 */
	@Override
	public void onStop(Session session) {
		Logs.info(session.getId() + ": 退出会话");
	}

	/**
	 * 会话过期时触发
	 */
	@Override
	public void onExpiration(Session session) {
		Logs.info(session.getId() + ": 会话过期");
	}
}