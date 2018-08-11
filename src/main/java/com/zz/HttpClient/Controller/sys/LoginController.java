package com.zz.HttpClient.Controller.sys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zz.HttpClient.Bean.Sys.Principal;
import com.zz.HttpClient.Controller.BaseController;
import com.zz.HttpClient.Shiro.filter.LoginAuthenticationFilter;
import com.zz.HttpClient.Util.Logs;
import com.zz.HttpClient.Util.StringUtils;
import com.zz.HttpClient.Util.UserUtils;

/**
 * 
 * @Title:LoginController
 * @Description:TODO(登录Controller)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月10日 上午11:38:26
 */
@Controller
@RequestMapping("/sys")
public class LoginController extends BaseController {
	
	/**
	 * 
	 * @Title：login
	 * @Description: TODO(登录管理)
	 * @see：
	 * @param session
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		
		Principal principal = UserUtils.getPrincipal();
		
		// 如果已经登录，则跳转到管理首页
		if(principal != null && !principal.isMobileLogin()){
			return "redirect:" + "/sys/loginSuccess";
		} 
		
		return "sys/login";
	}
	
	/**
	 * 
	 * @Title：loginFail
	 * @Description: TODO(登录失败，真正登录的POST请求由Filter完成)
	 * @see：
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginFail(HttpServletRequest request, HttpServletResponse response, Model model) {
		Principal principal = UserUtils.getPrincipal();
		
		// 如果已经登录，则跳转到管理首页
		if(principal != null) {
			return "redirect:" + "/sys/loginSuccess";
		}

		String username = WebUtils.getCleanParam(request, LoginAuthenticationFilter.DEFAULT_USERNAME_PARAM);
		boolean rememberMe = WebUtils.isTrue(request, LoginAuthenticationFilter.DEFAULT_REMEMBER_ME_PARAM);
		String exception = (String)request.getAttribute(LoginAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
		String message = (String)request.getAttribute(LoginAuthenticationFilter.DEFAULT_MESSAGE_PARAM);
		
		if (StringUtils.isBlank(message) || StringUtils.equals(message, "null")){
			message = "用户或密码错误, 请重试.";
		}

		
		Logs.info("username: " + username);
		Logs.info("rememberMe: " + rememberMe);
		Logs.info("exception: " + exception);
		Logs.info("message: " + message);
		
		return "login/login";
	}
	
	/**
	 * 
	 * @Title：index
	 * @Description: TODO(登录成功，进入管理首页)
	 * @see：
	 * @param request
	 * @param response
	 * @return
	 */
	@RequiresPermissions("user")
	@RequestMapping(value = "/loginSuccess")
	public String loginSuccess(HttpServletRequest request, HttpServletResponse response) {
		Logs.info("登录成功");
		return "sys/sysIndex";
	}

}
