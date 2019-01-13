package com.zz.HttpClient.modules.timer.web;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.groups.Default;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zz.HttpClient.common.entity.AjaxResult;
import com.zz.HttpClient.common.service.valid.CreateVaild;
import com.zz.HttpClient.common.utils.IdGen;
import com.zz.HttpClient.common.utils.Logs;
import com.zz.HttpClient.common.utils.httpClient.HttpStatus;
import com.zz.HttpClient.modules.timer.entity.DialTestTimer;
import com.zz.HttpClient.modules.timer.jobClass.DialTestJob;

/**
 * 
 * @Title:DialTestController
 * @Description:TODO(催收拨号测试Controller)
 * @Company: 
 * @author zhou.zhang
 * @date 2019年1月13日 下午2:38:01
 */
@Controller
@RequestMapping("/timer/dialTest")
@Validated
public class DialTestController extends BaseTimerController<DialTestJob>{

	/**
	 * 任务初始化
	 */
	@PostConstruct
	@Override
	public void init() {
		Logs.info("催收拨号测试任务初始化**************************");
	}

	/**
	 * 任务主界面
	 */
	@RequestMapping(value = "/main", method=RequestMethod.GET)
	@Override
	public String main(HttpServletRequest request, HttpServletResponse response) {
		return "sys/timer/dialTest/main";
	}

	/**
	 * 增加任务界面
	 */
	@RequestMapping(value = "/addTimer", method=RequestMethod.GET)
	@Override
	public String addTimer(HttpServletRequest request, HttpServletResponse response) {
		return "sys/timer/dialTest/addTimer";
	}

	/**
	 * 修改任务界面
	 */
	@Override
	public String editTimer(String jobName, HttpServletRequest request, HttpServletResponse response, Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 分页查询列表
	 */
	@Override
	public void findList(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 
	 * @Title：addJob
	 * @Description: TODO(添加定时任务)
	 * @see：
	 * @param collectionRobotTimer
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/addJob", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public void addJob(@Validated({ Default.class, CreateVaild.class }) @RequestBody DialTestTimer dialTestTimer, 
			HttpServletRequest request, HttpServletResponse response) {
		dialTestTimer.setJobName(IdGen.uuid());
		// 使用指定的执行类
		dialTestTimer.setJobClass(getJobClass());
		
		
		Logs.info("参数：" + dialTestTimer);
		for (String str : dialTestTimer.getMobileLabels()) {
			Logs.info("手机标签：" + str);
		}
		renderString(response, new AjaxResult(HttpStatus.SC_SUCCESS, "增加任务成功"));
	}
	
}
