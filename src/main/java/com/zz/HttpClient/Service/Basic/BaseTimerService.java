package com.zz.HttpClient.Service.Basic;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;

import com.zz.HttpClient.Bean.Basic.BaseEntity;
import com.zz.HttpClient.Dao.Basic.CrudDao;
import com.zz.HttpClient.Service.sys.timer.TimerMangeService;

/**
 * 
 * @Title:BaseTimerService
 * @Description:TODO(定时Service基类)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月24日 上午9:15:22
 */
@SuppressWarnings("hiding")
public abstract class BaseTimerService<D extends CrudDao<T>, T extends BaseEntity<T>> extends CrudService<D, T> {
	
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
	 */
	public abstract void addJob(T t);
	
	/**
	 * 
	 * @Title：startJob
	 * @Description: TODO(启动任务)
	 * @see：
	 * @param jobName
	 */
	public abstract void startJob(String jobName);
	
	/**
	 * 
	 * @Title：stopJob
	 * @Description: TODO(停止任务)
	 * @see：
	 * @param jobName
	 */
	public abstract void stopJob(String jobName);
	
	/**
	 * 
	 * @Title：updateJob
	 * @Description: TODO(更新任务)
	 * @see：
	 * @param t
	 */
	public abstract void updateJob(T t);
	
	/**
	 * 
	 * @Title：deleteJob
	 * @Description: TODO(删除任务)
	 * @see：
	 * @param jobName
	 */
	public abstract void deleteJob(String jobName);

}
 