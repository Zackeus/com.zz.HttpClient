package com.zz.HttpClient.Timer;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import com.zz.HttpClient.Util.DateUtils;
import com.zz.HttpClient.Util.Logs;

/**
 * 
 * @Title:CollectionRobotTimer
 * @Description:TODO(催收机器人排程任务)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月22日 上午8:26:50
 */
@Component
public class CollectionRobotJob implements Job {
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
        String name = context.getJobDetail().getKey().getName();
		Logs.info("定时任务 " + name + " 启动 : " + DateUtils.formatDateTime(new Date()));
	}
	
}
