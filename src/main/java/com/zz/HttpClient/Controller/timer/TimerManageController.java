package com.zz.HttpClient.Controller.timer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zz.HttpClient.Controller.basic.BaseController;

/**
 * 
 * @Title:TimerController
 * @Description:TODO(定时任务Controller)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月15日 下午6:29:09
 */
@Controller
@RequestMapping("/timer/manage")
public class TimerManageController extends BaseController {
	
	/**
	 * 
	 * @Title：timerMain
	 * @Description: TODO(任务配置主页面)
	 * @see：
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/main")
	public String timerMain(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "timer/timerMain";
	}

}
