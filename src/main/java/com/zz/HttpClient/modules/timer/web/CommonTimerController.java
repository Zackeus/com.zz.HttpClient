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
import com.zz.HttpClient.modules.timer.entity.CommonTimer;
import com.zz.HttpClient.modules.timer.service.CommonTimerService;

/**
 * 
 * @Title:CommonTimerController
 * @Description:TODO(普通定时Controller)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年12月12日 下午3:12:21
 */
@Controller
@RequestMapping("/timer/common")
public class CommonTimerController extends BaseTimerController<Object> {

	@Autowired
	CommonTimerService commonTimerService;
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	@Override
	public void init() {
		for (CommonTimer commonTimer : commonTimerService.findAllList()) {
			if (commonTimer.isStatus()) {
				try {
					timerMangeService.addJob(
							(Class<? extends Job>) (Class.forName((String) commonTimer.getJobClass())
									.newInstance().getClass()),
							commonTimer.getJobName(), commonTimer.getJobGroupName(),
							commonTimer.getJobTime());
				} catch (Exception e) {
					Logs.error(commonTimer.getJobName() +  " :初始化排程异常：" + Logs.toLog(e));
				}
			}
		}
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	@Override
	public String main(HttpServletRequest request, HttpServletResponse response) {
		return "sys/timer/common/main";
	}

	@RequestMapping(value = "/addTimer", method = RequestMethod.GET)
	@Override
	public String addTimer(HttpServletRequest request, HttpServletResponse response) {
		return "sys/timer/common/addTimer";
	}

	@RequestMapping(value = "/editTimer", method = RequestMethod.GET)
	@Override
	public String editTimer(@RequestParam(value = "jobName")String jobName, 
			HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("commonTimer", commonTimerService.get(jobName));
		return "sys/timer/common/editTimer";
	}

	@RequestMapping(value = "/findList")
	@Override
	public void findList(HttpServletRequest request, HttpServletResponse response) {
		renderString(response, commonTimerService.findPage(new Page<>(request), new CommonTimer()));
	}
	
	/**
	 * 
	 * @Title：addJob
	 * @Description: TODO(添加定时任务)
	 * @see：
	 * @param commonTimer
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/addJob", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public void addJob(
			@Validated({ Default.class, CreateVaild.class, SpecialVaild.class }) @RequestBody CommonTimer commonTimer,
			HttpServletRequest request, HttpServletResponse response) {
		commonTimer.setJobName(IdGen.uuid());
		commonTimerService.addJob(commonTimer);
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
	@RequestMapping(value = "/startJob")
	public void startJob(
			@DataVerificat(service = CommonTimerService.class) @RequestParam(value = "jobName") String jobName,
			HttpServletRequest request, HttpServletResponse response) {
		commonTimerService.startJob(new CommonTimer(jobName));
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
	@RequestMapping(value = "/stopJob")
	public void stopJob(
			@DataVerificat(service = CommonTimerService.class) @RequestParam(value = "jobName") String jobName,
			HttpServletRequest request, HttpServletResponse response) {
		commonTimerService.stopJob(new CommonTimer(jobName));
		renderString(response, new AjaxResult(HttpStatus.SC_SUCCESS, "停止任务成功"));
	}
	
	/**
	 * 
	 * @Title：updateJob
	 * @Description: TODO(更新定时任务) 
	 * @see：
	 * @param collectionRobotTimer
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/updateJob", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public void updateJob(
			@Validated({ Default.class, UpdateVaild.class,
					SpecialVaild.class }) @RequestBody CommonTimer commonTimer,
			HttpServletRequest request, HttpServletResponse response) {
		// 更新启动
		commonTimer.setStatus(true);
		commonTimerService.updateJob(commonTimer);
		renderString(response, new AjaxResult(HttpStatus.SC_SUCCESS, "更新任务成功"));
	}

	/**
	 * 
	 * @Title：deleteJob
	 * @Description: TODO(删除job)
	 * @see：
	 * @param jobName
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/deleteJob")
	public void deleteJob(
			@DataVerificat(service = CommonTimerService.class) @RequestParam(value = "jobName") String jobName,
			HttpServletRequest request, HttpServletResponse response) {
		commonTimerService.deleteJob(new CommonTimer(jobName));
		renderString(response, new AjaxResult(HttpStatus.SC_SUCCESS, "删除任务成功"));
	}

}
