package com.zz.HttpClient.Service.sys.timer;

import org.quartz.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zz.HttpClient.Bean.Sys.User;
import com.zz.HttpClient.Bean.Sys.timer.collectionRobot.CollectionRobotTimer;
import com.zz.HttpClient.Dao.sys.timer.CollectionRobotTimerDao;
import com.zz.HttpClient.Service.Basic.CrudService;
import com.zz.HttpClient.Util.StringUtils;
import com.zz.HttpClient.Util.UserUtils;
import com.zz.HttpClient.Util.exception.TimerException;

/**
 * 
 * @Title:CollectionRobotTimerService
 * @Description:TODO(催收机器人定时任务Service)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月21日 下午2:16:41
 */
@Service("collectionRobotTimerService")
public class CollectionRobotTimerService extends CrudService<CollectionRobotTimerDao, CollectionRobotTimer> {
	
	@Autowired
	TimerMangeService timerMangeService;
	
	@Autowired
	CollectionRobotTimerDao collectionRobotTimerDao;
	
	@Cacheable(value = {"sysTimerCache"}, key="#jobName")
	@Override
	public CollectionRobotTimer get(String jobName) {
		return super.get(jobName);
	}
	
	/**
	 * 
	 * @Title：Update
	 * @Description: TODO(更新单笔数据)
	 * @see：
	 * @param collectionRobotTimer
	 * @return
	 */
	@CacheEvict(value = {"sysTimerCache"}, key = "#collectionRobotTimer.jobName",  beforeInvocation = true)
	public int Update(CollectionRobotTimer collectionRobotTimer) {
		collectionRobotTimer.preUpdate();
		return collectionRobotTimerDao.update(collectionRobotTimer);
	}
	
	/**
	 * 
	 * @Title：updateStatusById
	 * @Description: TODO(根据ID更新任务当前状态)
	 * @see：
	 * @param collectionRobotTimer
	 * @param status
	 * @return
	 */
	@CacheEvict(value = {"sysTimerCache"}, key = "#collectionRobotTimer.jobName",  beforeInvocation = true)
	public int updateStatusByJobName(CollectionRobotTimer collectionRobotTimer, boolean status) {
		if (collectionRobotTimer.isStatus() != status) {
			return collectionRobotTimerDao.updateStatusByJobName(collectionRobotTimer, status);
		}
		return 0;
	}
	
	/**
	 * 
	 * @Title：Delete
	 * @Description: TODO(删除单笔数据)
	 * @see：
	 * @param collectionRobotTimer
	 * @return
	 */
	@CacheEvict(value = {"sysTimerCache"}, key = "#collectionRobotTimer.jobName",  beforeInvocation = true)
	@Override
	public void delete(CollectionRobotTimer collectionRobotTimer) {
		super.delete(collectionRobotTimer);
	}
	
	/**
	 * 
	 * @Title：addJob
	 * @Description: TODO(添加任务)
	 * @see：
	 * @param collectionRobotTimer
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void addJob(CollectionRobotTimer collectionRobotTimer) {
		try {
			User user = UserUtils.getUser();
			if (StringUtils.isNotBlank(user.getId())) {
				collectionRobotTimer.setCreateBy(user);
				collectionRobotTimer.setUpdateBy(user);
			}
			collectionRobotTimerDao.insert(collectionRobotTimer);
			
			if (collectionRobotTimer.isStatus()) {
				timerMangeService.addJob(
						(Class<? extends Job>) (Class.forName((String) collectionRobotTimer.getJobClass()).newInstance()
								.getClass()),
						collectionRobotTimer.getJobName(), collectionRobotTimer.getJobGroupName(),
						collectionRobotTimer.getJobTime());
			}
		} catch (Exception e) {
			throw new TimerException("添加任务失败：" + e.getMessage());
		}
	}
	
	/**
	 * 
	 * @Title：startJob
	 * @Description: TODO(启动任务)
	 * @see：
	 * @param jobName
	 */
	@SuppressWarnings("unchecked")
	@CacheEvict(value = {"sysTimerCache"}, key = "#jobName",  beforeInvocation = true)
	public void startJob(String jobName) {
		try {
			CollectionRobotTimer collectionRobotTimer = get(jobName);
			updateStatusByJobName(collectionRobotTimer, true);
			String state = timerMangeService.getJobState(collectionRobotTimer.getJobName(),
					collectionRobotTimer.getJobGroupName());
			switch (state) {
			case  TimerMangeService.JOB_STATUS_NONE:
				// 任务不存在 注册任务执行
				timerMangeService.addJob(
						(Class<? extends Job>) (Class.forName((String) collectionRobotTimer.getJobClass()).newInstance()
								.getClass()),
						collectionRobotTimer.getJobName(), collectionRobotTimer.getJobGroupName(),
						collectionRobotTimer.getJobTime());
				break;

			case TimerMangeService.JOB_STATUS_PAUSED:
				// 暂停状态 恢复运行
				timerMangeService.resumeJob(collectionRobotTimer.getJobName(), collectionRobotTimer.getJobGroupName());
				break;

			case TimerMangeService.JOB_STATUS_NORMAL:
				// 任务正常运行 不需要操作
				break;

			default:
				throw new TimerException("未知的任务状态,启动任务失败，当前状态：" + state);
			}
		} catch (Exception e) {
			throw new TimerException("启动任务失败：：" + e.getMessage());
		}
	}
	
	/**
	 * 
	 * @Title：stopJob
	 * @Description: TODO(停止任务)
	 * @see：
	 * @param jobName
	 */
	@CacheEvict(value = {"sysTimerCache"}, key = "#jobName",  beforeInvocation = true)
	public void stopJob(String jobName) {
		try {
			CollectionRobotTimer collectionRobotTimer = get(jobName);
			updateStatusByJobName(collectionRobotTimer, false);
			
			String state = timerMangeService.getJobState(collectionRobotTimer.getJobName(),
					collectionRobotTimer.getJobGroupName());
			if (StringUtils.isNoneEmpty(state) && StringUtils.equals(TimerMangeService.JOB_STATUS_NORMAL, state)) {
				timerMangeService.pauseJob(collectionRobotTimer.getJobName(), collectionRobotTimer.getJobGroupName());
			}
		} catch (Exception e) {
			throw new TimerException("停止任务失败：" + e.getMessage());
		}
	}
	
	/**
	 * 
	 * @Title：updateJob
	 * @Description: TODO(更新任务)
	 * @see：
	 * @param collectionRobotTimer
	 */
	@SuppressWarnings("unchecked")
	@CacheEvict(value = {"sysTimerCache"}, key = "#collectionRobotTimer.jobName",  beforeInvocation = true)
	public void updateJob(CollectionRobotTimer collectionRobotTimer) {
		try {
			Update(collectionRobotTimer);
			updateStatusByJobName(collectionRobotTimer, true);

			if (timerMangeService.checkJobExist(collectionRobotTimer.getJobName(),
					collectionRobotTimer.getJobGroupName())) {
				// 任务已经注册 进行更新操作
				timerMangeService.updateJob(collectionRobotTimer.getJobName(), collectionRobotTimer.getJobGroupName(),
						collectionRobotTimer.getJobTime());
			} else {
				// 任务未注册 添加 JOB
				timerMangeService.addJob(
						(Class<? extends Job>) (Class.forName((String) collectionRobotTimer.getJobClass()).newInstance()
								.getClass()),
						collectionRobotTimer.getJobName(), collectionRobotTimer.getJobGroupName(),
						collectionRobotTimer.getJobTime());
			}
		} catch (Exception e) {
			throw new TimerException("更新任务失败：" + e.getMessage());
		}
	}
	
	/**
	 * 
	 * @Title：deleteJob
	 * @Description: TODO(删除任务)
	 * @see：
	 * @param jobName
	 */
	@CacheEvict(value = {"sysTimerCache"}, key = "#jobName",  beforeInvocation = true)
	public void deleteJob(String jobName) {
		try {
			CollectionRobotTimer collectionRobotTimer = get(jobName);
			delete(collectionRobotTimer);
			if (timerMangeService.checkJobExist(collectionRobotTimer.getJobName(),
					collectionRobotTimer.getJobGroupName())) {
				timerMangeService.deleteJob(collectionRobotTimer.getJobName(), collectionRobotTimer.getJobGroupName());
			}
		} catch (Exception e) {
			throw new TimerException("停止任务失败：" + e.getMessage());
		}
	}

}
