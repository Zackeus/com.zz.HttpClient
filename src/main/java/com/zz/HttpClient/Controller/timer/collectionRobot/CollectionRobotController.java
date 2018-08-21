package com.zz.HttpClient.Controller.timer.collectionRobot;

import java.util.concurrent.ScheduledFuture;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zz.HttpClient.Bean.Sys.timer.collectionRobot.CollectionRobotTimer;
import com.zz.HttpClient.Controller.basic.BaseCollectionRobotTimerController;
import com.zz.HttpClient.Util.Logs;

import net.sf.json.JSONObject;

/**
 * 
 * @Title:CollectionRobotController
 * @Description:TODO(催收机器人定时Controller)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月21日 上午11:56:58
 */
@Controller
@RequestMapping("/timer/collectionRobot")
public class CollectionRobotController extends BaseCollectionRobotTimerController {
	
	// 定时任务Id
	private static final String ID = "536b25b48d6846bbbd5f1d946f373456";
	
	private ScheduledFuture<?> future;

	@PostConstruct
	@Override
	public void init() {
		if (collectionRobotTimerService.get(ID).isStatus()) {
			startCron(null, null);
		}
	}

	@RequestMapping(value = "/updateCron")
	@Override
	public void updateCron(CollectionRobotTimer collectionRobotTimer, HttpServletRequest request,
			HttpServletResponse response) {
		
	}

	@RequestMapping(value = "/startCron")
	@Override
	public void startCron(HttpServletRequest request, HttpServletResponse response) {
		
	}

	@RequestMapping(value = "/stopCron")
	@Override
	public void stopCron(HttpServletRequest request, HttpServletResponse response) {
		
	}

}
