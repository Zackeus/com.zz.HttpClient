package com.zz.HttpClient.Service.Basic;

import org.apache.poi.ss.formula.functions.T;
import org.quartz.Job;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;

import com.zz.HttpClient.Bean.Sys.timer.TimerJob;
import com.zz.HttpClient.Dao.Basic.CrudDao;
import com.zz.HttpClient.Service.sys.timer.TimerMangeService;
import com.zz.HttpClient.Util.StringUtils;
import com.zz.HttpClient.Util.exception.MyException;

/**
 * 
 * @Title:BaseTimerService
 * @Description:TODO(定时Service基类)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月24日 上午9:15:22
 */
@SuppressWarnings("hiding")
public abstract class BaseTimerService<D extends CrudDao<T>, T extends TimerJob<T>> extends CrudService<D, T> {
	
	@Autowired
	protected TimerMangeService timerMangeService;
	
	// 默认任务组名
	protected static final String JOB_GROUP_NAME = "EXTJWEB_JOBGROUP_NAME";

	// JOB 任务不存在状态字段
	protected static final String JOB_STATUS_NONE = "NONE";

	// JOB 任务正常运行状态字段
	protected static final String JOB_STATUS_NORMAL = "NORMAL";

	// JOB 任务暂停状态字段
	protected static final String JOB_STATUS_PAUSED = "PAUSED";
	
	/**
	 * 
	 * @Title：addJob
	 * @Description: TODO(添加任务)
	 * @see：
	 * @param t
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	protected void addJob(T t) throws Exception {
		timerMangeService.addJob(
				(Class<? extends Job>) (Class.forName((String) t.getJobClass()).newInstance().getClass()),
				t.getJobName(), t.getJobGroupName(), t.getJobTime());
	}
	
	/**
	 * 
	 * @Title：startJob
	 * @Description: TODO(启动任务)
	 * @see：
	 * @param jobName
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	protected void startJob(T t) throws Exception {
		String state = timerMangeService.getJobState(t.getJobName(), t.getJobGroupName());
		switch (state) {
		
		case JOB_STATUS_NONE:
			// 任务不存在 注册任务执行
			timerMangeService.addJob(
					(Class<? extends Job>) (Class.forName((String) t.getJobClass()).newInstance().getClass()),
					t.getJobName(), t.getJobGroupName(), t.getJobTime());
			break;

		case JOB_STATUS_PAUSED:
			// 暂停状态 恢复运行
			timerMangeService.resumeJob(t.getJobName(), t.getJobGroupName());
			break;

		case JOB_STATUS_NORMAL:
			// 任务正常运行 不需要操作
			break;

		default:
			throw new MyException("未知的任务状态,启动任务失败，当前状态：" + state);
		}
	}
	
	/**
	 * 
	 * @Title：stopJob
	 * @Description: TODO(停止任务)
	 * @see：
	 * @param jobName
	 * @throws SchedulerException 
	 */
	protected void stopJob(T t) throws SchedulerException {
		String state = timerMangeService.getJobState(t.getJobName(), t.getJobGroupName());
		if (StringUtils.isNoneEmpty(state) && StringUtils.equals(JOB_STATUS_NORMAL, state)) {
			timerMangeService.pauseJob(t.getJobName(), t.getJobGroupName());
		}
	}
	
	/**
	 * 
	 * @Title：updateJob
	 * @Description: TODO(更新任务)
	 * @see：
	 * @param t
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	protected void updateJob(T t) throws Exception {
		if (timerMangeService.checkJobExist(t.getJobName(), t.getJobGroupName())) {
			// 任务已经注册 进行更新操作
			timerMangeService.updateJob(t.getJobName(), t.getJobGroupName(), t.getJobTime());
		} else {
			// 任务未注册 添加 JOB
			timerMangeService.addJob(
					(Class<? extends Job>) (Class.forName((String) t.getJobClass()).newInstance().getClass()),
					t.getJobName(), t.getJobGroupName(), t.getJobTime());
		}
	}
	
	/**
	 * 
	 * @Title：deleteJob
	 * @Description: TODO(删除任务)
	 * @see：
	 * @param jobName
	 * @throws SchedulerException 
	 */
	protected void deleteJob(T t) throws SchedulerException {
		if (timerMangeService.checkJobExist(t.getJobName(), t.getJobGroupName())) {
			timerMangeService.deleteJob(t.getJobName(), t.getJobGroupName());
		}
	}

}
 