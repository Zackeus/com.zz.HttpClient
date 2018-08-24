package com.zz.HttpClient.Controller.sys.timer;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quartz.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zz.HttpClient.Bean.Basic.LayuiResult;
import com.zz.HttpClient.Bean.Basic.Page;
import com.zz.HttpClient.Bean.Sys.timer.collectionRobot.CollectionRobotTimer;
import com.zz.HttpClient.Controller.basic.BaseTimerController;
import com.zz.HttpClient.Job.CollectionRobotJob;
import com.zz.HttpClient.Service.sys.timer.CollectionRobotTimerService;
import com.zz.HttpClient.Util.IdGen;
import com.zz.HttpClient.Util.Logs;

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
public class CollectionRobotTimerController extends BaseTimerController<CollectionRobotTimer, CollectionRobotJob> {
	
	@Autowired
	CollectionRobotTimerService collectionRobotTimerService;

	@SuppressWarnings("unchecked")
	@PostConstruct
	@Override
	public void init() {
		for (CollectionRobotTimer collectionRobotTimer : collectionRobotTimerService.findAllList()) {
			if (collectionRobotTimer.isStatus()) {
				try {
					timerMangeService.addJob(
							(Class<? extends Job>) (Class.forName((String) collectionRobotTimer.getJobClass())
									.newInstance().getClass()),
							collectionRobotTimer.getJobName(), collectionRobotTimer.getJobGroupName(),
							collectionRobotTimer.getJobTime());
				} catch (Exception e) {
					Logs.error("初始化催收机器人排程异常：" + e.getMessage());
				}
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

	@RequestMapping(value = "/addJob", produces = "application/json;charset=UTF-8")
	@Override
	public void addJob(@RequestBody CollectionRobotTimer collectionRobotTimer, HttpServletRequest request,
			HttpServletResponse response) {
		collectionRobotTimer.setJobName(IdGen.uuid());
		// 使用指定的执行类
		collectionRobotTimer.setJobClass(getJobClass());
		collectionRobotTimer.setUpdateDate(new Date());
		collectionRobotTimer.setCreateDate(collectionRobotTimer.getUpdateDate());
		collectionRobotTimerService.addJob(collectionRobotTimer);
		renderString(response, new LayuiResult(0, "增加任务成功"));
	}

	@RequestMapping(value = "/startJob")
	@Override
	public void startJob(@RequestParam(value = "jobName") String jobName, HttpServletRequest request,
			HttpServletResponse response) {
		collectionRobotTimerService.startJob(jobName);
		renderString(response, new LayuiResult(0, "启动任务成功"));
	}

	@RequestMapping(value = "/stopJob")
	@Override
	public void stopJob(@RequestParam(value = "jobName") String jobName, HttpServletRequest request,
			HttpServletResponse response) {
		collectionRobotTimerService.stopJob(jobName);
		renderString(response, new LayuiResult(0, "停止任务成功"));
	}

	@RequestMapping(value = "/updateJob", produces = "application/json;charset=UTF-8")
	@Override
	public void updateJob(@RequestBody CollectionRobotTimer collectionRobotTimer, HttpServletRequest request,
			HttpServletResponse response) {
		// 更新启动
		collectionRobotTimer.setStatus(true);
		collectionRobotTimerService.updateJob(collectionRobotTimer);
		renderString(response, new LayuiResult(0, "更新任务成功"));
	}

	@RequestMapping(value = "/deleteJob")
	@Override
	public void deleteJob(@RequestParam(value = "jobName") String jobName, HttpServletRequest request,
			HttpServletResponse response) {
		collectionRobotTimerService.deleteJob(jobName);
		renderString(response, new LayuiResult(0, "删除任务成功"));
	}

}
