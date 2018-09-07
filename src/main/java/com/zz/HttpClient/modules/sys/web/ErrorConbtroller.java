package com.zz.HttpClient.modules.sys.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zz.HttpClient.common.entity.AjaxResult;
import com.zz.HttpClient.common.utils.WebUtils;
import com.zz.HttpClient.common.web.BaseController;

/**
 * 
 * @Title:ErrorConbtroller
 * @Description:TODO(异常页面跳转控制器)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月24日 上午10:43:53
 */
@Controller
@RequestMapping("/sys/error")
public class ErrorConbtroller extends BaseController {
	
	/**
	 * 
	 * @Title：not
	 * @Description: TODO(404页面)
	 * @see：
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/404")
	public String pageNotExist(HttpServletRequest request, HttpServletResponse response) {
		if (WebUtils.isAjaxRequest(request)) {
			renderString(response, new AjaxResult(404, "访问路径不存在"));
			return null;
		} 
		return "error/404";
	}

}
