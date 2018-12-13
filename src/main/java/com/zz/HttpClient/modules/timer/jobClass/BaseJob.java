package com.zz.HttpClient.modules.timer.jobClass;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.zz.HttpClient.common.utils.Logs;
import com.zz.HttpClient.common.utils.ObjectUtils;
import com.zz.HttpClient.modules.timer.entity.CommonTimer;
import com.zz.HttpClient.modules.timer.service.CommonTimerService;


/**
 * 
 * @Title:BaseJob
 * @Description:TODO(定时任务基类)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年12月13日 上午9:53:49
 */
public abstract class BaseJob implements Job {
	
	@Autowired
	protected CommonTimerService commonTimerService;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		String jobName = context.getJobDetail().getKey().getName();
		Exception exception = null;
		try {
			boolean continueChain = preHandle(jobName);
            if (continueChain) 
            	executeJob(jobName);
            afterHandle(jobName);
		} catch (Exception e) {
			exception = e;
		} finally {
			cleanup(jobName, exception);
		}
	}
	
	/**
	 * 
	 * @Title：preHandle
	 * @Description: TODO(前置操作)
	 * @see：
	 * @param jobName
	 * @return
	 */
	protected boolean preHandle(String jobName) {
		CommonTimer commonTimer = commonTimerService.get(jobName);
		// 是否异常重启
		if (commonTimer.isRestart())
			return !commonTimerService.isSuccess(jobName);
		return Boolean.TRUE;
	}
	
	/**
	 * 
	 * @Title：executeJob
	 * @Description: TODO(执行任务)
	 * @see：
	 * @param jobName
	 */
	protected void executeJob(String jobName) {
		
	}
	
	/**
	 * 
	 * @Title：afterHandle
	 * @Description: TODO(后置操作)
	 * @see：
	 */
	protected void afterHandle(String jobName) {
		commonTimerService.updateRes(jobName, Boolean.TRUE);
	}
	
	/**
	 * 
	 * @Title：cleanup
	 * @Description: TODO(异常处理)
	 * @see：
	 * @param e
	 * @throws JobExecutionException 
	 * @throws Exception 
	 */
	protected void cleanup(String jobName, Exception e) throws JobExecutionException  {
		if (ObjectUtils.isNotEmpty(e)) {
			Logs.error(jobName + " :定时任务异常：" + Logs.toLog(e));
			commonTimerService.updateRes(jobName, Boolean.FALSE);
			throw new JobExecutionException(Logs.toLog(e));
		}
	}

}
