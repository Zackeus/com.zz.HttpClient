package com.zz.HttpClient.Controller.timer;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

import javax.annotation.PostConstruct;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zz.HttpClient.Controller.basic.BaseTimerController;
import com.zz.HttpClient.Util.Logs;

@Controller
@RequestMapping("/testTimer")
public class TestTimerController extends BaseTimerController {
	
	// 定时任务Id
	private static final String ID = "8b7e8a33ccb946738f4252528ea6961e";
	
	private ScheduledFuture<?> future;

	private String cron = "";

	@PostConstruct
	@Override
	public void init() {
		if (timerService.get(ID).isStatus()) {
			updateCron("*/3 * * * * ?");
		}
	}

	@RequestMapping(value = "/getCron")
	@ResponseBody
	@Override
	public String getCron() {
		return cron;
	}

	@RequestMapping(value = "/updateCron")
	@Override
	public void updateCron(@RequestParam(value = "cron") String cron) {
		this.cron = cron;
		startCron();
	}

	@RequestMapping(value = "/startCron")
	@Override
	public void startCron() {
		String cron = getCron();
		stopCron();
		try {
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
		} catch (Exception e) {
			Logs.error("启动定时任务失败");
		}
	}

	@RequestMapping(value = "/stopCron")
	@Override
	public void stopCron() {
		if (future != null) {
			// 取消任务调度
			future.cancel(true);
		}
	}
	
}
