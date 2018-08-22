package com.zz.HttpClient.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zz.HttpClient.Bean.Basic.Page;
import com.zz.HttpClient.Bean.Msg.BusinessSMS;
import com.zz.HttpClient.Service.BusinessSMSService;
import com.zz.HttpClient.Service.SendOdCustomerService;
import com.zz.HttpClient.Util.Logs;

@Controller
@RequestMapping("/test")
public class TestController {
	
//	@Autowired
//	private TimerTask timerTask;
	
	@Autowired
	private BusinessSMSService businessSMSService;
	
	@Resource(name = "sendOdCustomerService")
	private SendOdCustomerService sendOdCustomerService;
	
	@RequestMapping(value = "/task")
	public String testTask(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		timerTask.sendOdGuarantee();
//		timerTask.sendOdCustomer();
		return "testTask";
	}
	
	@RequestMapping(value = "/testData")
	public void testData(HttpServletRequest request, HttpServletResponse response) {
//		Logs.info(businessSMSService.get("15e9d08e2480007"));
		
		Page<BusinessSMS> page = businessSMSService.findPage(new Page<>(10), new BusinessSMS());
		
		for(BusinessSMS businessSMS : page.getList()) {
			Logs.info(businessSMS);
		}
	}
}
