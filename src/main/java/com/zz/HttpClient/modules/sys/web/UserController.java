package com.zz.HttpClient.modules.sys.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zz.HttpClient.common.entity.Page;
import com.zz.HttpClient.common.utils.WebUtils;
import com.zz.HttpClient.common.web.BaseController;
import com.zz.HttpClient.modules.sys.entity.Principal;
import com.zz.HttpClient.modules.sys.service.UserService;
import com.zz.HttpClient.modules.sys.utils.UserUtils;

/**
 * 
 * @Title:UserController
 * @Description:TODO(用户Controller)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月15日 上午9:25:13
 */
@Controller
@RequestMapping("/sys/user")
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 
	 * @Title：logout
	 * @Description: TODO(用户退出)
	 * @see：
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequiresPermissions("user")
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Principal principal = UserUtils.getPrincipal();
		if (principal != null) {
			UserUtils.getSubject().logout();
		}
		return "redirect:" + "/sys/login";
	}
	
	/**
	 * 
	 * @Title：userMange
	 * @Description: TODO(用户管理)
	 * @see：
	 * @param request
	 * @param response
	 */
	@RequiresRoles(value = { "admin" })
	@RequestMapping(value = "/manage")
	public String userManage(HttpServletRequest request, HttpServletResponse response) {
		if (WebUtils.isAjaxRequest(request)) {
			renderString(response, userService.findPage(new Page<>(request), UserUtils.getUser()));
			return null;
		}
		return "/sys/user/userManage";
	}
	
}
