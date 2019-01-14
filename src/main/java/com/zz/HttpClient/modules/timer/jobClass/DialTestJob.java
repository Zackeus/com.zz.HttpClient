package com.zz.HttpClient.modules.timer.jobClass;

import org.quartz.DisallowConcurrentExecution;
import org.springframework.stereotype.Component;

import com.zz.HttpClient.common.utils.Logs;

/**
 * 
 * @Title:DialTestJob
 * @Description:TODO(催收拨号测试排程任务)
 * @Company: 
 * @author zhou.zhang
 * @date 2019年1月13日 下午2:35:40
 */
@Component
@DisallowConcurrentExecution
public class DialTestJob extends BaseJob {

	/**
	 * 前置操作
	 */
	@Override
	protected boolean preHandle(String jobName) {
		return Boolean.TRUE;
	}
	
	/**
	 * 任务执行
	 */
	@Override
	protected void executeJob(String jobName) {
		Logs.info("拨号测试任务执行*********************");
	}

	/**
	 * 后置操作
	 */
	@Override
	protected void afterHandle(String jobName) {
		
	}


}
