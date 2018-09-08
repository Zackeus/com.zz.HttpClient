package com.zz.HttpClient.modules.timer.web;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.groups.Default;

import org.quartz.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zz.HttpClient.common.annotation.validator.DataVerificat;
import com.zz.HttpClient.common.entity.AjaxResult;
import com.zz.HttpClient.common.entity.Page;
import com.zz.HttpClient.common.service.valid.CreateVaild;
import com.zz.HttpClient.common.service.valid.SpecialVaild;
import com.zz.HttpClient.common.service.valid.UpdateVaild;
import com.zz.HttpClient.common.utils.IdGen;
import com.zz.HttpClient.common.utils.Logs;
import com.zz.HttpClient.modules.timer.entity.collectionRobot.CollectionRobotTimer;
import com.zz.HttpClient.modules.timer.jobClass.CollectionRobotJob;
import com.zz.HttpClient.modules.timer.service.CollectionRobotTimerService;

/**
 * 
 * @Title:QuartzManagerController
 * @Description:TODO(催收机器人定时Controller)
 * @Company:
 * @author zhou.zhang
 * @date 2018年8月21日 下午4:13:29
 */
@Controller
@RequestMapping("/timer/collectionRobot")
@Validated
public class CollectionRobotTimerController extends BaseTimerController<CollectionRobotJob> {

	@Autowired
	CollectionRobotTimerService collectionRobotTimerService;

	@SuppressWarnings("unchecked")
	@PostConstruct
	@Override
	public void init() {
		for (CollectionRobotTimer collectionRobotTimer : collectionRobotTimerService.findAllList()) {
			if (collectionRobotTimer.isStatus()) {
//				try {
//					timerMangeService.addJob(
//							(Class<? extends Job>) (Class.forName((String) collectionRobotTimer.getJobClass())
//									.newInstance().getClass()),
//							collectionRobotTimer.getJobName(), collectionRobotTimer.getJobGroupName(),
//							collectionRobotTimer.getJobTime());
//				} catch (Exception e) {
//					Logs.error("初始化催收机器人排程异常：" + e.getMessage());
//				}
			}
		}
	}

	@RequestMapping(value = "/main")
	@Override
	public String main(HttpServletRequest request, HttpServletResponse response) {
		return "sys/timer/collectionRobot/main";
	}

	@RequestMapping(value = "/addTimer")
	@Override
	public String addTimer(HttpServletRequest request, HttpServletResponse response) {
		return "sys/timer/collectionRobot/addTimer";
	}

	@RequestMapping(value = "/editTimer")
	@Override
	public String editTimer(@RequestParam(value = "jobName") String jobName, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		model.addAttribute("collectionRobotTimer", collectionRobotTimerService.get(jobName));
		return "sys/timer/collectionRobot/editTimer";
	}

	@RequestMapping(value = "/findList")
	@Override
	public void findList(HttpServletRequest request, HttpServletResponse response) {
		renderString(response, collectionRobotTimerService.findPage(new Page<>(request), new CollectionRobotTimer()));
	}

	/**
	 * 
	 * @Title：addJob
	 * @Description: TODO(增加定时任务) 
	 * @see：
	 * @param collectionRobotTimer
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/addJob", produces = "application/json;charset=UTF-8")
	public void addJob(
			@Validated({ Default.class, CreateVaild.class }) @RequestBody CollectionRobotTimer collectionRobotTimer,
			HttpServletRequest request, HttpServletResponse response) {
		collectionRobotTimer.setJobName(IdGen.uuid());
		// 使用指定的执行类
		collectionRobotTimer.setJobClass(getJobClass());
		collectionRobotTimer.setUpdateDate(new Date());
		collectionRobotTimer.setCreateDate(collectionRobotTimer.getUpdateDate());
		collectionRobotTimerService.addJob(collectionRobotTimer);
		renderString(response, new AjaxResult(0, "增加任务成功"));
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
			@DataVerificat(service = CollectionRobotTimerService.class) @RequestParam(value = "jobName") String jobName,
			HttpServletRequest request, HttpServletResponse response) {
		collectionRobotTimerService.startJob(new CollectionRobotTimer(jobName));
		renderString(response, new AjaxResult(0, "启动任务成功"));
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
			@DataVerificat(service = CollectionRobotTimerService.class) @RequestParam(value = "jobName") String jobName,
			HttpServletRequest request, HttpServletResponse response) {
		collectionRobotTimerService.stopJob(new CollectionRobotTimer(jobName));
		renderString(response, new AjaxResult(0, "停止任务成功"));
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
	@RequestMapping(value = "/updateJob", produces = "application/json;charset=UTF-8")
	public void updateJob(
			@Validated({ Default.class, UpdateVaild.class,
					SpecialVaild.class }) @RequestBody CollectionRobotTimer collectionRobotTimer,
			HttpServletRequest request, HttpServletResponse response) {
		// 更新启动
		collectionRobotTimer.setStatus(true);
		collectionRobotTimerService.updateJob(collectionRobotTimer);
		renderString(response, new AjaxResult(0, "更新任务成功"));
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
			@DataVerificat(service = CollectionRobotTimerService.class) @RequestParam(value = "jobName") String jobName,
			HttpServletRequest request, HttpServletResponse response) {
		collectionRobotTimerService.deleteJob(new CollectionRobotTimer(jobName));
		renderString(response, new AjaxResult(0, "删除任务成功"));
	}

}
