package com.zz.HttpClient.Timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import com.zz.HttpClient.Util.Logs;

/**
 * 
 * @Title:TestTask
 * @Description:TODO(定时任务 可动态修改执行时间 开启/关闭任务)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年7月23日 下午3:50:14
 */
@Component
public class TestTask {
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	private ThreadPoolTaskScheduler threadPoolTaskScheduler;
	
    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler(){
        return new ThreadPoolTaskScheduler();
    }

	private ScheduledFuture<?> future;

	private String cron = "";

	public void setCron(String cron) {
		this.cron = cron;
	}

	public String getCron() {
		return cron;
	}
	
	public ScheduledFuture<?> getFuture() {
		return future;
	}

	public void setFuture(ScheduledFuture<?> future) {
		this.future = future;
	}

	/**
	 * 
	 * @Title:startCron
	 * @Description: TODO(启动定时任务)
	 * @param cron
	 */
	public void startCron(final String cron) {
		setCron(cron);
		stopCron();
		future = threadPoolTaskScheduler.schedule(new Runnable() {

			@Override
			public void run() {
				// 任务逻辑
				Logs.info("当前时间：" + dateFormat.format(new Date()));
			}
		}, new Trigger() {

			@Override
			public Date nextExecutionTime(TriggerContext triggerContext) {
				if ("".equals(cron) || cron == null)
					return null;
				// 定时任务触发，可修改定时任务的执行周期
				CronTrigger trigger = new CronTrigger(cron);
				Date nextExecDate = trigger.nextExecutionTime(triggerContext);
				return nextExecDate;
			}
		});
	}

	/**
	 * 
	 * @Title:stopCron
	 * @Description: TODO(关闭定时任务)
	 */
	public void stopCron() {
		if (future != null) {
			// 取消任务调度
			future.cancel(true);
		}
	}
}
