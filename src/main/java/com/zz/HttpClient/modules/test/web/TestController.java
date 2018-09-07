package com.zz.HttpClient.modules.test.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zz.HttpClient.modules.timer.service.SendOdCustomerService;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Resource(name = "sendOdCustomerService")
	private SendOdCustomerService sendOdCustomerService;
	
	@RequestMapping(value = "/task")
	public String testTask(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "testTask";
	}
}
