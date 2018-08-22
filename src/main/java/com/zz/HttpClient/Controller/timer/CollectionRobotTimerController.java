package com.zz.HttpClient.Controller.timer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zz.HttpClient.Bean.Basic.Page;
import com.zz.HttpClient.Bean.Sys.timer.collectionRobot.CollectionRobotTimer;
import com.zz.HttpClient.Controller.basic.BaseController;
import com.zz.HttpClient.Service.sys.timer.CollectionRobotTimerService;
import com.zz.HttpClient.Service.sys.timer.TimerMangeService;
import com.zz.HttpClient.Timer.CollectionRobotJob;
import com.zz.HttpClient.Util.IdGen;
import com.zz.HttpClient.Util.Logs;

/**
 * 
 * @Title:QuartzManagerController
 * @Description:TODO(催收机器人定时Controller)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月21日 下午4:13:29
 */
@Controller
@RequestMapping("/timer/collectionRobot")
public class CollectionRobotTimerController extends BaseController {
	
	private static String JOB_GROUP_NAME = "EXTJWEB_JOBGROUP_NAME";
	
	@Autowired
	private TimerMangeService timerMangeService;
	
	@Autowired
	CollectionRobotTimerService collectionRobotTimerService;
	
	/**
	 * 
	 * @Title：timerMain
	 * @Description: TODO(任务列表页面)
	 * @see：
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/main")
	public String main(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "timer/collectionRobotTimer";
	}
	
	/**
	 * 
	 * @Title：findList
	 * @Description: TODO(分页查询定时任务列表)
	 * @see：
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/findList")
	public void findList(HttpServletRequest request, HttpServletResponse response) {
		renderString(response, collectionRobotTimerService.findPage(new Page<>(request), new CollectionRobotTimer() ));
	}
	
    @RequestMapping(value = "/startJob")
    public void startJob(HttpServletRequest request, HttpServletResponse response) {
    	Logs.info("启动任务");
    	timerMangeService.addJob(CollectionRobotJob.class, IdGen.uuid(), JOB_GROUP_NAME, "0/3 * * * * ?");
    }

}
