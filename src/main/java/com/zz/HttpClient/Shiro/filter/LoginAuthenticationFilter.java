package com.zz.HttpClient.Shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Service;

import com.zz.HttpClient.Util.Logs;
import com.zz.HttpClient.Util.StringUtils;

/**
 * 
 * @Title:LoginAuthenticationFilter
 * @Description:TODO(登录验证过滤类)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月10日 下午2:22:55
 */
@Service
public class LoginAuthenticationFilter extends org.apache.shiro.web.filter.authc.FormAuthenticationFilter {
	
	public static final String DEFAULT_MESSAGE_PARAM = "message";
	
	private String messageParam = DEFAULT_MESSAGE_PARAM;
	
	public String getMessageParam() {
		return messageParam;
	}
	
	@Override
	protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
		Logs.info("登录认证");
		return super.executeLogin(request, response);
	}

	/**
	 * 认证成功跳转
	 */
	@Override
	protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {
		WebUtils.issueRedirect(request, response, getSuccessUrl(), null, true);
	}
	
	/**
	 * 登录失败事件
	 */
	@Override
	protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		String className = e.getClass().getName(), message = "";
		if (IncorrectCredentialsException.class.getName().equals(className)
				|| UnknownAccountException.class.getName().equals(className)){
			message = "用户或密码错误, 请重试.";
		}
		else if (e.getMessage() != null && StringUtils.startsWith(e.getMessage(), "msg:")){
			message = StringUtils.replace(e.getMessage(), "msg:", "");
		}
		
		else{
			message = "系统出现点问题，请稍后再试！";
			e.printStackTrace(); // 输出到控制台
		}
        request.setAttribute(getFailureKeyAttribute(), className);
        request.setAttribute(getMessageParam(), message);
        return true;
	}
	
}
