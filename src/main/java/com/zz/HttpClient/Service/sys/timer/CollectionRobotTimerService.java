package com.zz.HttpClient.Service.sys.timer;

import org.quartz.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zz.HttpClient.Bean.Sys.User;
import com.zz.HttpClient.Bean.Sys.timer.collectionRobot.CollectionRobotTimer;
import com.zz.HttpClient.Dao.sys.timer.CollectionRobotTimerDao;
import com.zz.HttpClient.Service.Basic.BaseTimerService;
import com.zz.HttpClient.Util.StringUtils;
import com.zz.HttpClient.Util.UserUtils;
import com.zz.HttpClient.Util.exception.MyException;

/**
 * 
 * @Title:CollectionRobotTimerService
 * @Description:TODO(催收机器人定时任务Service)
 * @Company:
 * @author zhou.zhang
 * @date 2018年8月21日 下午2:16:41
 */
@Service("collectionRobotTimerService")
public class CollectionRobotTimerService extends BaseTimerService<CollectionRobotTimerDao, CollectionRobotTimer> {

	@Autowired
	CollectionRobotTimerDao collectionRobotTimerDao;

	@Cacheable(value = { "sysTimerCache" }, key = "#jobName")
	@Override
	public CollectionRobotTimer get(String jobName) {
		return super.get(jobName);
	}

	/**
	 * 
	 * @Title：updateStatusById
	 * @Description: TODO(根据ID更新任务当前状态) @see：
	 * @param collectionRobotTimer
	 * @param status
	 * @return
	 */
	public int updateStatusByJobName(CollectionRobotTimer collectionRobotTimer, boolean status) {
		if (collectionRobotTimer.isStatus() != status) {
			return collectionRobotTimerDao.updateStatusByJobName(collectionRobotTimer, status);
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addJob(CollectionRobotTimer t) {
		try {
			t.setJobGroupName(JOB_GROUP_NAME);
			User user = UserUtils.getUser();
			if (StringUtils.isNotBlank(user.getId())) {
				t.setCreateBy(user);
				t.setUpdateBy(user);
			}
			collectionRobotTimerDao.insert(t);

			if (t.isStatus()) {
				timerMangeService.addJob(
						(Class<? extends Job>) (Class.forName((String) t.getJobClass()).newInstance().getClass()),
						t.getJobName(), t.getJobGroupName(), t.getJobTime());
			}
		} catch (Exception e) {
			throw new MyException("添加任务失败：" + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@CacheEvict(value = { "sysTimerCache" }, key = "#jobName", beforeInvocation = true)
	@Override
	public void startJob(String jobName) {
		try {
			CollectionRobotTimer collectionRobotTimer = get(jobName);
			updateStatusByJobName(collectionRobotTimer, true);
			String state = timerMangeService.getJobState(collectionRobotTimer.getJobName(),
					collectionRobotTimer.getJobGroupName());
			switch (state) {
			case JOB_STATUS_NONE:
				// 任务不存在 注册任务执行
				timerMangeService.addJob(
						(Class<? extends Job>) (Class.forName((String) collectionRobotTimer.getJobClass()).newInstance()
								.getClass()),
						collectionRobotTimer.getJobName(), collectionRobotTimer.getJobGroupName(),
						collectionRobotTimer.getJobTime());
				break;

			case JOB_STATUS_PAUSED:
				// 暂停状态 恢复运行
				timerMangeService.resumeJob(collectionRobotTimer.getJobName(), collectionRobotTimer.getJobGroupName());
				break;

			case JOB_STATUS_NORMAL:
				// 任务正常运行 不需要操作
				break;

			default:
				throw new MyException("未知的任务状态,启动任务失败，当前状态：" + state);
			}
		} catch (Exception e) {
			throw new MyException("启动任务失败：：" + e.getMessage());
		}
	}

	@CacheEvict(value = { "sysTimerCache" }, key = "#jobName", beforeInvocation = true)
	@Override
	public void stopJob(String jobName) {
		try {
			CollectionRobotTimer collectionRobotTimer = get(jobName);
			updateStatusByJobName(collectionRobotTimer, false);

			String state = timerMangeService.getJobState(collectionRobotTimer.getJobName(),
					collectionRobotTimer.getJobGroupName());
			if (StringUtils.isNoneEmpty(state) && StringUtils.equals(JOB_STATUS_NORMAL, state)) {
				timerMangeService.pauseJob(collectionRobotTimer.getJobName(), collectionRobotTimer.getJobGroupName());
			}
		} catch (Exception e) {
			throw new MyException("停止任务失败：" + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@CacheEvict(value = { "sysTimerCache" }, key = "#t.jobName", beforeInvocation = true)
	@Override
	public void updateJob(CollectionRobotTimer t) {
		try {
			t.preUpdate();
			collectionRobotTimerDao.update(t);

			if (timerMangeService.checkJobExist(t.getJobName(), t.getJobGroupName())) {
				// 任务已经注册 进行更新操作
				timerMangeService.updateJob(t.getJobName(), t.getJobGroupName(), t.getJobTime());
			} else {
				// 任务未注册 添加 JOB
				timerMangeService.addJob(
						(Class<? extends Job>) (Class.forName((String) t.getJobClass()).newInstance().getClass()),
						t.getJobName(), t.getJobGroupName(), t.getJobTime());
			}
		} catch (Exception e) {
			throw new MyException("更新任务失败：" + e.getMessage());
		}
	}

	@CacheEvict(value = { "sysTimerCache" }, key = "#jobName", beforeInvocation = true)
	@Override
	public void deleteJob(String jobName) {
		try {
			CollectionRobotTimer collectionRobotTimer = get(jobName);
			super.delete(collectionRobotTimer);
			if (timerMangeService.checkJobExist(collectionRobotTimer.getJobName(),
					collectionRobotTimer.getJobGroupName())) {
				timerMangeService.deleteJob(collectionRobotTimer.getJobName(), collectionRobotTimer.getJobGroupName());
			}
		} catch (Exception e) {
			throw new MyException("停止任务失败：" + e.getMessage());
		}
	}

}
