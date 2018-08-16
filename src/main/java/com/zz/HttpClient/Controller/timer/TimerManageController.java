package com.zz.HttpClient.Controller.timer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zz.HttpClient.Bean.Basic.LayuiPage;
import com.zz.HttpClient.Bean.Basic.Page;
import com.zz.HttpClient.Bean.Sys.Timer;
import com.zz.HttpClient.Controller.basic.BaseController;
import com.zz.HttpClient.Service.sys.TimerService;

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
	
	@Autowired
	TimerService timerService;
	
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
	
	/**
	 * 
	 * @Title：findList
	 * @Description: TODO(分页查询定时任务列表)
	 * @see：
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/findList")
	public void findList(HttpServletRequest request, HttpServletResponse response) {
		renderString(response, new LayuiPage<>(timerService.findPage(new Page<>(), new Timer())));
	}

}
