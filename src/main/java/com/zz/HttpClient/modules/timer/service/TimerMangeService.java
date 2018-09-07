package com.zz.HttpClient.modules.timer.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.DateBuilder;
import org.quartz.DateBuilder.IntervalUnit;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.Trigger.TriggerState;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @Title:TimerMangeService
 * @Description:TODO(定时任务管理Service)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月21日 下午7:02:33
 */
@Service("timerMangeService")
public class TimerMangeService {
	
    @Autowired
    private Scheduler scheduler;
    
    /**
     * 
     * @Title：addJob
     * @Description: TODO(增加一个job)
     * @see：
     * @param jobClass 任务实现类
     * @param jobName 任务名称
     * @param jobGroupName 任务组名
     * @param jobTime 时间表达式 （如：0/5 * * * * ? ）
     * @throws SchedulerException 
     */
    public void addJob(Class<? extends Job> jobClass, String jobName, String jobGroupName, String jobTime) throws SchedulerException {
        //创建jobDetail实例，绑定Job实现类  
        //指明job的名称，所在组的名称，以及绑定job类
    	//任务名称和组构成任务key
        JobDetail jobDetail = JobBuilder.newJob(jobClass)
                        .withIdentity(jobName, jobGroupName)
                        .build();
        //定义调度触发规则  
        //使用cornTrigger规则 
        Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(jobName, jobGroupName)
                    .startAt(DateBuilder.futureDate(1, IntervalUnit.SECOND))
                    .withSchedule(CronScheduleBuilder.cronSchedule(jobTime))
                    .startNow().build();
        //把作业和触发器注册到任务调度中
        scheduler.scheduleJob(jobDetail, trigger);
        // 启动
        if (!scheduler.isShutdown()) {
        	scheduler.start();
        }
    }
    
    /**
     * 
     * @Title：addJob
     * @Description: TODO(增加一个job)
     * @see：
     * @param jobClass 任务实现类
     * @param jobName 任务名称
     * @param jobGroupName 任务组名
     * @param jobTime 时间表达式 (这是每隔多少秒为一次任务)
     * @throws SchedulerException 
     */
    public void addJob(Class<? extends Job> jobClass, String jobName, String jobGroupName, int jobTime) throws SchedulerException {
    	addJob(jobClass, jobName, jobGroupName, jobTime, -1);
    }
    
    /**
     * 
     * @Title：addJob
     * @Description: TODO(增加一个job)
     * @see：
     * @param jobClass 任务实现类
     * @param jobName 任务名称
     * @param jobGroupName 任务组名
     * @param jobTime 时间表达式 (这是每隔多少秒为一次任务)
     * @param jobTimes 运行的次数 （<0:表示不限次数）
     * @throws SchedulerException 
     */
    public void addJob(Class<? extends Job> jobClass, String jobName, String jobGroupName, int jobTime, int jobTimes) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(jobClass)
        		.withIdentity(jobName, jobGroupName)
                .build();
        Trigger trigger = null;
        if(jobTimes < 0) {
        	trigger = TriggerBuilder.newTrigger().withIdentity(jobName, jobGroupName)
                    .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(1).withIntervalInSeconds(jobTime))  
                    .startNow().build();
        } else {
        	trigger = TriggerBuilder.newTrigger().withIdentity(jobName, jobGroupName)
                    .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(1).withIntervalInSeconds(jobTime).withRepeatCount(jobTimes))  
                    .startNow().build();
        }
        scheduler.scheduleJob(jobDetail, trigger);
        if (!scheduler.isShutdown()) {
        	scheduler.start();
        }
    }
    
    /**
     * 
     * @Title：updateJob
     * @Description: TODO(修改 一个job的 时间表达式)
     * @see：
     * @param jobName
     * @param jobGroupName
     * @param jobTime
     * @throws SchedulerException 
     */
    public void updateJob(String jobName, String jobGroupName, String jobTime) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroupName);  
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);  
        trigger = trigger.getTriggerBuilder().withIdentity(triggerKey)
                .withSchedule(CronScheduleBuilder.cronSchedule(jobTime))
                .build();
        //重启触发器
        scheduler.rescheduleJob(triggerKey, trigger);
    }
    
    /**
     * 
     * @Title：deleteJob
     * @Description: TODO(删除任务一个job)
     * @see：
     * @param jobName 任务名称
     * @param jobGroupName 任务组名
     * @throws SchedulerException 
     */
    public void deleteJob(String jobName, String jobGroupName) throws SchedulerException {
    	scheduler.deleteJob(JobKey.jobKey(jobName, jobGroupName));
    }
    
    /**
     * 
     * @Title：pauseJob
     * @Description: TODO(暂停一个job)
     * @see：
     * @param jobName
     * @param jobGroupName
     * @throws SchedulerException 
     */
    public void pauseJob(String jobName, String jobGroupName) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(jobName, jobGroupName);  
        scheduler.pauseJob(jobKey);
    }
    
    /**
     * 
     * @Title：resumeJob
     * @Description: TODO(恢复一个job)
     * @see：
     * @param jobName
     * @param jobGroupName
     * @throws SchedulerException 
     */
    public void resumeJob(String jobName, String jobGroupName) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(jobName, jobGroupName);
        scheduler.resumeJob(jobKey);
    }
    
    /**
     * 
     * @Title：runAJobNow
     * @Description: TODO(立即执行一个job)
     * @see：
     * @param jobName
     * @param jobGroupName
     * @throws SchedulerException 
     */
    public void runAJobNow(String jobName, String jobGroupName) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(jobName, jobGroupName);
        scheduler.triggerJob(jobKey);
    }
    
    /**
     * 
     * @Title：checkJobExist
     * @Description: TODO(判断任务是否存在)
     * @see：
     * @param jobName
     * @param jobGroupName
     * @return
     * @throws SchedulerException
     */
    public boolean checkJobExist(String jobName, String jobGroupName) throws SchedulerException {
    	return scheduler.checkExists(JobKey.jobKey(jobName, jobGroupName));
    }
    
    /**
     * 
     * @Title：getJobState
     * @Description: TODO(查询其中任务的状态)
     * @see：
     * @param jobName
     * @param jobGroupName
     * @return
     * @throws SchedulerException 
     */
    public String getJobState(String jobName, String jobGroupName) throws SchedulerException {
		TriggerState triggerState = scheduler.getTriggerState(TriggerKey.triggerKey(jobName, jobGroupName));
		return triggerState.name();
    }
    
    /**
     * 
     * @Title：queryAllJob
     * @Description: TODO(获取所有计划中的任务列表)
     * @see：
     * @return
     * @throws SchedulerException 
     */
    public List<Map<String,Object>> queryAllJob() throws SchedulerException {
        GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();  
        Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
        List<Map<String,Object>> jobList = new ArrayList<Map<String,Object>>();  
        for (JobKey jobKey : jobKeys) {  
        	List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);  
        	for (Trigger trigger : triggers) {
        		Map<String,Object> map = new HashMap<>();
        		map.put("jobName", jobKey.getName());
        		map.put("jobGroupName", jobKey.getGroup());
        		map.put("description", "触发器:" + trigger.getKey());
        		Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());  
        		map.put("jobStatus", triggerState.name());
        		if (trigger instanceof CronTrigger) {  
        			CronTrigger cronTrigger = (CronTrigger) trigger;  
        			String cronExpression = cronTrigger.getCronExpression();  
        			map.put("jobTime",cronExpression);
        		}  
        		jobList.add(map);  
        	}  
        }  
        return jobList;  
    }
    
    /**
     * 
     * @Title：queryRunJon
     * @Description: TODO(获取所有正在运行的job)
     * @see：
     * @return
     * @throws SchedulerException 
     */
    public List<Map<String,Object>> queryRunJon() throws SchedulerException {
        List<JobExecutionContext> executingJobs = scheduler.getCurrentlyExecutingJobs();
        List<Map<String,Object>> jobList = new ArrayList<Map<String,Object>>(executingJobs.size());  
        for (JobExecutionContext executingJob : executingJobs) {  
            Map<String,Object> map = new HashMap<String, Object>();  
            JobDetail jobDetail = executingJob.getJobDetail();  
            JobKey jobKey = jobDetail.getKey();  
            Trigger trigger = executingJob.getTrigger(); 
            map.put("jobName", jobKey.getName());
            map.put("jobGroupName", jobKey.getGroup());
            map.put("description", "触发器:" + trigger.getKey());
            Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());  
            map.put("jobStatus", triggerState.name());
            if (trigger instanceof CronTrigger) {  
                CronTrigger cronTrigger = (CronTrigger) trigger;  
                String cronExpression = cronTrigger.getCronExpression();  
                map.put("jobTime",cronExpression);
            }  
            jobList.add(map);  
        }  
        return jobList;  
    }

}
