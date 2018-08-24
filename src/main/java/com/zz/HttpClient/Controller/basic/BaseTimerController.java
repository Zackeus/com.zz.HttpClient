package com.zz.HttpClient.Controller.basic;

import java.lang.reflect.ParameterizedType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zz.HttpClient.Service.sys.timer.TimerMangeService;

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
public abstract class BaseTimerController<T, J> extends BaseController {
	
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
	 * @Title：addTimer
	 * @Description: TODO(增加任务界面)
	 * @see：
	 * @param request
	 * @param response
	 * @return
	 */
	public abstract String addTimer(HttpServletRequest request, HttpServletResponse response);

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
	 * @Title：addJob
	 * @Description: TODO(增加定时任务)
	 * @see：
	 * @param t
	 * @param request
	 * @param response
	 * @throws SchedulerException 
	 * @throws Exception 
	 */
	public abstract void addJob(T t, HttpServletRequest request, HttpServletResponse response);
	
	/**
	 * 
	 * @Title：startJob
	 * @Description: TODO(启动定时任务) 
	 * @see：
	 * @param request
	 * @param response
	 * @throws SchedulerException 
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
	public abstract void stopJob(String jobName, HttpServletRequest request, HttpServletResponse response);

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
	public abstract void updateJob(T t, HttpServletRequest request, HttpServletResponse response);
	
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
	public abstract void deleteJob(String jobName, HttpServletRequest request, HttpServletResponse response);

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
	 * @Title：getJobClass
	 * @Description: TODO(子类 job 执行类，可以使用指定的执行类，也可使用动态的执行类)
	 * @see：
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getJobClass() {
        Class<J> jobClass = (Class <J>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];  
		return jobClass.getName();
	}

}
