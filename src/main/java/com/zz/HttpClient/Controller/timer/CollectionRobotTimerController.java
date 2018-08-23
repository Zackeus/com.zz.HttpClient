package com.zz.HttpClient.Controller.timer;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quartz.Job;
import org.quartz.SchedulerException;
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
import com.zz.HttpClient.Service.sys.timer.CollectionRobotTimerService;
import com.zz.HttpClient.Util.Logs;
import com.zz.HttpClient.Util.StringUtils;

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
public class CollectionRobotTimerController extends BaseTimerController<CollectionRobotTimer> {

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

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/startJob")
	@Override
	public void startJob(@RequestParam(value = "jobName") String jobName, HttpServletRequest request,
			HttpServletResponse response) {
		CollectionRobotTimer collectionRobotTimer = collectionRobotTimerService.get(jobName);
		String state = timerMangeService.getJobState(collectionRobotTimer.getJobName(),
				collectionRobotTimer.getJobGroupName());
		try {
			switch (state) {
			case JOB_STATUS_NONE:
				// 任务不存在 注册任务执行
				timerMangeService.addJob(
						(Class<? extends Job>) (Class.forName((String) collectionRobotTimer.getJobClass()).newInstance()
								.getClass()),
						collectionRobotTimer.getJobName(), collectionRobotTimer.getJobGroupName(),
						collectionRobotTimer.getJobTime());
				break;

			case JOB_STATUS_PAUSED:
				// 暂停状态 恢复运行
				timerMangeService.resumeJob(collectionRobotTimer.getJobName(), collectionRobotTimer.getJobGroupName());
				break;	
			
			case JOB_STATUS_NORMAL:
				// 任务正常运行 不需要操作
				break;

			default:
				renderString(response, new LayuiResult(-1, "未知的任务状态,启动任务失败，当前状态：" + state));
				return;
			}
		} catch (Exception e) {
			renderString(response, new LayuiResult(-2, "启动任务失败, 信息：" + e.getMessage()));
			return;
		}
		
		collectionRobotTimerService.updateStatusByJobName(collectionRobotTimer, true);
		renderString(response, new LayuiResult(0, "启动任务成功"));
	}

	@RequestMapping(value = "/stopJob")
	@Override
	public void stopJob(@RequestParam(value = "jobName") String jobName, HttpServletRequest request,
			HttpServletResponse response) throws SchedulerException {
		CollectionRobotTimer collectionRobotTimer = collectionRobotTimerService.get(jobName);
		String state = timerMangeService.getJobState(collectionRobotTimer.getJobName(), collectionRobotTimer.getJobGroupName());
		if (StringUtils.isNoneEmpty(state) && StringUtils.equals(JOB_STATUS_NORMAL, state)) {
			timerMangeService.pauseJob(collectionRobotTimer.getJobName(), collectionRobotTimer.getJobGroupName());
		}
		collectionRobotTimerService.updateStatusByJobName(collectionRobotTimer, false);
		renderString(response, new LayuiResult(0, "停止任务成功"));
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/updateJob", produces = "application/json;charset=UTF-8")
	@Override
	public void updateJob(@RequestBody CollectionRobotTimer collectionRobotTimer, 
			HttpServletRequest request, HttpServletResponse response) throws SchedulerException {
		collectionRobotTimerService.Update(collectionRobotTimer);
		
		if (timerMangeService.checkJobExist(collectionRobotTimer.getJobName(),
				collectionRobotTimer.getJobGroupName())) {
			// 任务已经注册 进行更新操作
			timerMangeService.updateJob(collectionRobotTimer.getJobName(), collectionRobotTimer.getJobGroupName(), 
					collectionRobotTimer.getJobTime());
		} else {
			try {
				// 任务未注册 添加 JOB
				timerMangeService.addJob(
						(Class<? extends Job>) (Class.forName((String) collectionRobotTimer.getJobClass())
						.newInstance().getClass()),
				collectionRobotTimer.getJobName(), collectionRobotTimer.getJobGroupName(),
				collectionRobotTimer.getJobTime());
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				renderString(response, new LayuiResult(-1, "更新任务失败：" + e.getMessage()));
			}
		}
		
		collectionRobotTimerService.updateStatusByJobName(collectionRobotTimer, true);
		renderString(response, new LayuiResult(0, "更新任务成功"));
	}

	@RequestMapping(value = "/deleteJob")
	@Override
	public void deleteJob(@RequestParam(value = "jobName") String jobName, HttpServletRequest request, 
			HttpServletResponse response) throws SchedulerException {
		CollectionRobotTimer collectionRobotTimer = collectionRobotTimerService.get(jobName);
		if (timerMangeService.checkJobExist(collectionRobotTimer.getJobName(),
				collectionRobotTimer.getJobGroupName())) {
			timerMangeService.deleteJob(collectionRobotTimer.getJobName(), collectionRobotTimer.getJobGroupName());
		}
		collectionRobotTimerService.delete(collectionRobotTimer);
		renderString(response, new LayuiResult(0, "删除任务成功"));
	}

}
