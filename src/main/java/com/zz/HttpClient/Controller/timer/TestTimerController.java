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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zz.HttpClient.Bean.Basic.LayuiResult;
import com.zz.HttpClient.Bean.Sys.timer.Timer;
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

	@PostConstruct
	@Override
	public void init() {
		if (timerService.get(ID).isStatus()) {
			startCron(null, null);
		}
	}

	@RequestMapping(value = "/updateCron")
	@Override
	public void updateCron(@RequestBody Timer timer, HttpServletRequest request, 
			HttpServletResponse response) {
		try {
			timerService.updateCronById(new Timer(ID, timer.getCron()));
		} catch (Exception e) {
			renderString(response, new LayuiResult(-1, "更新定时策略失败；信息：" + e.getMessage()));
		}
		startCron(request, response);
	}

	@RequestMapping(value = "/startCron")
	@Override
	public void startCron(HttpServletRequest request, HttpServletResponse response) {
		Timer timer = timerService.get(ID);
		
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
					if ("".equals(timer.getCron()) || timer.getCron() == null)
						return null;
					// 定时任务触发，可修改定时任务的执行周期
					CronTrigger trigger = new CronTrigger(timer.getCron());
					Date nextExecDate = trigger.nextExecutionTime(triggerContext);
					return nextExecDate;
				}
			});
	    	
	    	if (!timer.isStatus()) {
	    		timerService.updateStatusById(new Timer(ID, true));
			}
	    	
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
			timerService.updateStatusById(new Timer(ID, false));
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
