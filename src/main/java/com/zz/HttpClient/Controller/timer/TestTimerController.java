package com.zz.HttpClient.Controller.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zz.HttpClient.Util.Logs;

@Controller
@RequestMapping("/testTimer")
public class TestTimerController {
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	private ThreadPoolTaskScheduler threadPoolTaskScheduler;
	
    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler(){
        return new ThreadPoolTaskScheduler();
    }

	private ScheduledFuture<?> future;

	private String cron = "";
	
	@PostConstruct
	public void init() {
		Logs.info("定时任务初始化");
		startCron("*/3 * * * * ?");
	}

	/**
	 * 
	 * @Title：setCron
	 * @Description: TODO(更新定时策略)
	 * @see：
	 * @param cron
	 */
	@RequestMapping(value = "/setCron")
	public void setCron(@RequestParam(value = "cron") String cron) {
		this.cron = cron;
	}

	/**
	 * 
	 * @Title：getCron
	 * @Description: TODO(获取当前定时策略)
	 * @see：
	 * @return
	 */
	@RequestMapping(value = "/getCron")
	@ResponseBody
	public String getCron() {
		return cron;
	}
	
	/**
	 * 
	 * @Title：isFuture
	 * @Description: TODO(当前状态)
	 * @see：
	 */
	@RequestMapping(value = "/isFuture")
	public void isFuture() {
		if (future != null) {
			Logs.info("正在启动");
		}
		Logs.info("关闭状态");
	}

	/**
	 * 
	 * @Title:startCron
	 * @Description: TODO(启动定时任务)
	 * @param cron
	 */
	@RequestMapping(value = "/startCron")
	public void startCron(@RequestParam(value = "cron") String cron) {
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
	@RequestMapping(value = "/stopCron")
	public void stopCron() {
		if (future != null) {
			// 取消任务调度
			future.cancel(true);
		}
	}

}
