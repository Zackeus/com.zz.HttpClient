package com.zz.HttpClient.Controller.basic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zz.HttpClient.Bean.Basic.LayuiResult;
import com.zz.HttpClient.Service.sys.timer.TimerMangeService;
import com.zz.HttpClient.Util.WebUtils;

/**
 * 
 * @Title:BaseTimerController
 * @Description:TODO(定时任务支持类)
 * @Company:
 * @author zhou.zhang
 * @param <T>
 * @date 2018年8月16日 上午11:22:14
 */
@Component
public abstract class BaseTimerController<T> extends BaseController {

	// 默认任务组名
	protected static final String JOB_GROUP_NAME = "EXTJWEB_JOBGROUP_NAME";

	// JOB 任务不存在状态字段
	protected static final String JOB_STATUS_NONE = "NONE";

	// JOB 任务正常运行状态字段
	protected static final String JOB_STATUS_NORMAL = "NORMAL";

	// JOB 任务暂停状态字段
	protected static final String JOB_STATUS_PAUSED = "PAUSED";

	@Autowired
	protected TimerMangeService timerMangeService;

	/**
	 * 
	 * @Title：init
	 * @Description: TODO(定时任务初始化) 
	 * @see：
	 */
	public abstract void init();

	/**
	 * 
	 * @Title：main
	 * @Description: TODO(任务主界面) 
	 * @see：
	 * @param request
	 * @param response
	 */
	public abstract String main(HttpServletRequest request, HttpServletResponse response);

	/**
	 * 
	 * @Title：editTimer
	 * @Description: TODO(修改任务界面) 
	 * @see：
	 * @param jobName
	 * @param request
	 * @param response
	 * @return
	 */
	public abstract String editTimer(String jobName, HttpServletRequest request, HttpServletResponse response,
			Model model);

	/**
	 * 
	 * @Title：findList
	 * @Description: TODO(分页查询列表) 
	 * @see：
	 * @param request
	 * @param response
	 */
	public abstract void findList(HttpServletRequest request, HttpServletResponse response);

	/**
	 * 
	 * @Title：startJob
	 * @Description: TODO(启动定时任务) 
	 * @see：
	 * @param request
	 * @param response
	 */
	public abstract void startJob(String jobName, HttpServletRequest request, HttpServletResponse response);

	/**
	 * 
	 * @Title：stopJob
	 * @Description: TODO(停止定时任务) 
	 * @see：
	 * @param jobName
	 * @param request
	 * @param response
	 * @throws SchedulerException
	 */
	public abstract void stopJob(String jobName, HttpServletRequest request, HttpServletResponse response)
			throws SchedulerException;

	/**
	 * 
	 * @Title：updateJob
	 * @Description: TODO(更新定时任务) 
	 * @see：
	 * @param t
	 * @param request
	 * @param response
	 * @throws SchedulerException
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public abstract void updateJob(T t, HttpServletRequest request, HttpServletResponse response) throws SchedulerException;
	
	/**
	 * 
	 * @Title：deleteJob
	 * @Description: TODO(删除job)
	 * @see：
	 * @param jobName
	 * @param request
	 * @param response
	 * @throws SchedulerException
	 */
	public abstract void deleteJob(String jobName, HttpServletRequest request, HttpServletResponse response) throws SchedulerException;

	/**
	 * 
	 * @Title：cron
	 * @Description: TODO(定时任务策略页面) 
	 * @see：
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/cron")
	public String cron(HttpServletRequest request, HttpServletResponse response) {
		return "sys/timer/cron";
	}

	/**
	 * 
	 * @Title：schedulerException
	 * @Description: TODO(定时任务操作异常) 
	 * @see：
	 * @param request
	 * @param response
	 * @return
	 */
	@ExceptionHandler({ SchedulerException.class })
	public String schedulerException(HttpServletRequest request, HttpServletResponse response, SchedulerException e) {
		if (WebUtils.isAjaxRequest(request)) {
			renderString(response, new LayuiResult(-1, "操作定时任务异常：" + e.getMessage()));
			return null;
		} else {
			return "sys/Error";
		}
	}

}
