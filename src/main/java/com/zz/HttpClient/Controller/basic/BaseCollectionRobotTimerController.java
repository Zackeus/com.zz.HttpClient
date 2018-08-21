package com.zz.HttpClient.Controller.basic;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import com.zz.HttpClient.Bean.Sys.timer.collectionRobot.CollectionRobotTimer;
import com.zz.HttpClient.Service.sys.timer.CollectionRobotTimerService;

/**
 * 
 * @Title:BaseCollectionRobotTimerController
 * @Description:TODO(催收定时任务基类)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月21日 下午1:26:06
 */
@Component
public abstract class BaseCollectionRobotTimerController extends BaseController {
	
	protected static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Autowired
	protected CollectionRobotTimerService collectionRobotTimerService;
	
	@Autowired
	protected ThreadPoolTaskScheduler threadPoolTaskScheduler;
	
    @Bean
    protected ThreadPoolTaskScheduler threadPoolTaskScheduler(){
        return new ThreadPoolTaskScheduler();
    }
    
    /**
     * 
     * @Title：init
     * @Description: TODO(定时任务初始化)
     * @see：
     */
    public abstract void init();
    
    /**
     * 
     * @Title：updateCron
     * @Description: TODO(更新定时策略)
     * @see：
     * @param cron
     */
    public abstract void updateCron(CollectionRobotTimer collectionRobotTimer, HttpServletRequest request, 
    		HttpServletResponse response);
    
    /**
     * 
     * @Title：startCron
     * @Description: TODO(启动定时策略)
     * @see：
     */
    public abstract void startCron(HttpServletRequest request, HttpServletResponse response);
    
    /**
     * 
     * @Title：stopCron
     * @Description: TODO(停止定时策略)
     * @see：
     */
    public abstract void stopCron(HttpServletRequest request, HttpServletResponse response);

}
