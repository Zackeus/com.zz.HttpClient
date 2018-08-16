package com.zz.HttpClient.Controller.timer;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zz.HttpClient.Bean.Basic.LayuiResult;
import com.zz.HttpClient.Controller.basic.BaseTimerController;
import com.zz.HttpClient.Util.Logs;

/**
 * 
 * @Title:TimerController
 * @Description:TODO(定时测试任务Controller)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月15日 下午6:29:09
 */
@Controller
@RequestMapping("/testTimer")
public class TestTimerController extends BaseTimerController {
	
	// 定时任务Id
	private static final String ID = "8b7e8a33ccb946738f4252528ea6961e";
	
	private ScheduledFuture<?> future;

	private String cron = "*/3 * * * * ?";

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

	private void updateCron(String cron) {
		updateCron(cron, null, null);
	}
	
	@RequestMapping(value = "/updateCron")
	@Override
	public void updateCron(@RequestParam(value = "cron") String cron, 
			HttpServletRequest request, HttpServletResponse response) {
		this.cron = cron;
		startCron(request, response);
	}

	@RequestMapping(value = "/startCron")
	@Override
	public void startCron(HttpServletRequest request, HttpServletResponse response) {
		String cron = getCron();
		try {
			/*启动任务前停止上一个执行任务 达到新的定时策略能够立即执行*/
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
	    	renderString(response, new LayuiResult(0, "操作成功"));
		} catch (Exception e) {
			Logs.error("启动定时任务失败");
			renderString(response, new LayuiResult(-1, "启动任务失败；信息：" + e.getMessage()));
		}
	}

	private void stopCron() {
		stopCron(null, null);
	}
	
	@RequestMapping(value = "/stopCron")
	@Override
	public void stopCron(HttpServletRequest request, HttpServletResponse response) {
		try {
			if (future != null) {
				// 取消任务调度
				future.cancel(true);
			}
			renderString(response, new LayuiResult(0, "操作成功"));
		} catch (Exception e) {
			if (request != null) {
				renderString(response, new LayuiResult(-1, "停止任务失败; 信息：" + e.getMessage()));
				return;
			}
			throw e;
		}
	}
	
}
