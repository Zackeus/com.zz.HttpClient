package com.zz.HttpClient.Controller.sys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zz.HttpClient.Bean.Sys.Principal;
import com.zz.HttpClient.Controller.BaseController;
import com.zz.HttpClient.Util.UserUtils;

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
	
	@RequestMapping(value = "/clearCache")
	public void clearCache(HttpServletRequest request, HttpServletResponse response) {
		UserUtils.clearCache();
	}

}
