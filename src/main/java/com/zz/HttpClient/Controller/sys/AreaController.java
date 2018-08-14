package com.zz.HttpClient.Controller.sys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zz.HttpClient.Controller.BaseController;

/**
 * 
 * @Title:AreaController
 * @Description:TODO(区域Controller)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月14日 下午3:55:54
 */
@Controller
@RequestMapping("/sys/area")
public class AreaController extends BaseController {
	
	/**
	 * 
	 * @Title：loginSuccess
	 * @Description: TODO(管理副页面)
	 * @see：
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequiresPermissions("user")
	@RequestMapping(value = "/main")
	public String sysMain(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "sys/sysMain";
	}

}
