package com.zz.HttpClient.modules.timer.web;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.groups.Default;

import org.quartz.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zz.HttpClient.common.annotation.validator.DataVerificat;
import com.zz.HttpClient.common.entity.AjaxResult;
import com.zz.HttpClient.common.entity.Page;
import com.zz.HttpClient.common.service.valid.CreateVaild;
import com.zz.HttpClient.common.service.valid.SpecialVaild;
import com.zz.HttpClient.common.service.valid.UpdateVaild;
import com.zz.HttpClient.common.utils.IdGen;
import com.zz.HttpClient.common.utils.Logs;
import com.zz.HttpClient.common.utils.httpClient.HttpStatus;
import com.zz.HttpClient.modules.timer.entity.DialTestTimer;
import com.zz.HttpClient.modules.timer.jobClass.DialTestJob;
import com.zz.HttpClient.modules.timer.service.DialTestTimerService;

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
public class DialTestController extends BaseTimerController<DialTestJob> {
	
	@Autowired
	DialTestTimerService dialTestTimerService;

	/**
	 * 任务初始化
	 */
	@SuppressWarnings("unchecked")
	@PostConstruct
	@Override
	public void init() {
		for (DialTestTimer dialTestTimer : dialTestTimerService.findAllList()) {
			if (dialTestTimer.isStatus()) {
				try {
					timerMangeService.addJob(
							(Class<? extends Job>) (Class.forName((String) dialTestTimer.getJobClass())
									.newInstance().getClass()),
							dialTestTimer.getJobName(), dialTestTimer.getJobGroupName(),
							dialTestTimer.getJobTime());
				} catch (Exception e) {
					Logs.error("初始化催收拨打测试排程异常：" + Logs.toLog(e));
				}
			}
		}
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
	@RequestMapping(value = "/editTimer", method=RequestMethod.GET)
	@Override
	public String editTimer(@RequestParam(value = "jobName") String jobName, 
			HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("dialTestTimer", dialTestTimerService.get(jobName));
		return "sys/timer/dialTest/editTimer";
	}

	/**
	 * 分页查询列表
	 */
	@RequestMapping(value = "/findList", method=RequestMethod.GET)
	@Override
	public void findList(HttpServletRequest request, HttpServletResponse response) {
		renderString(response, dialTestTimerService.findPage(new Page<>(request), new DialTestTimer()));
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
		dialTestTimer.initMobileLabelsStr();
		dialTestTimer.setJobName(IdGen.uuid());
		// 使用指定的执行类
		dialTestTimer.setJobClass(getJobClass());
		dialTestTimerService.addJob(dialTestTimer);
		renderString(response, new AjaxResult(HttpStatus.SC_SUCCESS, "增加任务成功"));
	}
	
	/**
	 * 
	 * @Title：startJob
	 * @Description: TODO(启动定时任务) 
	 * @see：
	 * @param jobName
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/startJob", method = RequestMethod.POST)
	public void startJob(
			@DataVerificat(service = DialTestTimerService.class) @RequestParam(value = "jobName") String jobName,
			HttpServletRequest request, HttpServletResponse response) {
		dialTestTimerService.startJob(new DialTestTimer(jobName));
		renderString(response, new AjaxResult(HttpStatus.SC_SUCCESS, "启动任务成功"));
	}

	/**
	 * 
	 * @Title：stopJob
	 * @Description: TODO(停止定时任务) 
	 * @see：
	 * @param jobName
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/stopJob", method = RequestMethod.POST)
	public void stopJob(
			@DataVerificat(service = DialTestTimerService.class) @RequestParam(value = "jobName") String jobName,
			HttpServletRequest request, HttpServletResponse response) {
		dialTestTimerService.stopJob(new DialTestTimer(jobName));
		renderString(response, new AjaxResult(HttpStatus.SC_SUCCESS, "停止任务成功"));
	}
	
	/**
	 * 
	 * @Title：updateJob
	 * @Description: TODO(更新定时任务)
	 * @see：
	 * @param dialTestTimer
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/updateJob", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public void updateJob(
			@Validated({ Default.class, UpdateVaild.class,
					SpecialVaild.class }) @RequestBody DialTestTimer dialTestTimer,
			HttpServletRequest request, HttpServletResponse response) {
		dialTestTimer.initMobileLabelsStr();
		// 更新启动
		dialTestTimer.setStatus(true);
		dialTestTimerService.updateJob(dialTestTimer);
		renderString(response, new AjaxResult(HttpStatus.SC_SUCCESS, "更新任务成功"));
	}
	
	/**
	 * 
	 * @Title：deleteJob
	 * @Description: TODO(删除定时任务)
	 * @see：
	 * @param jobName
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/deleteJob", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public void deleteJob(
			@DataVerificat(service = DialTestTimerService.class) @RequestParam(value = "jobName") String jobName,
			HttpServletRequest request, HttpServletResponse response) {
		dialTestTimerService.deleteJob(new DialTestTimer(jobName));
		renderString(response, new AjaxResult(HttpStatus.SC_SUCCESS, "删除任务成功"));
	}
	
}
