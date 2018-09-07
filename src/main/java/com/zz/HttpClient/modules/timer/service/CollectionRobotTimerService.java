package com.zz.HttpClient.modules.timer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zz.HttpClient.common.utils.StringUtils;
import com.zz.HttpClient.common.utils.exception.MyException;
import com.zz.HttpClient.modules.sys.entity.User;
import com.zz.HttpClient.modules.sys.utils.UserUtils;
import com.zz.HttpClient.modules.timer.dao.CollectionRobotTimerDao;
import com.zz.HttpClient.modules.timer.entity.collectionRobot.CollectionRobotTimer;

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

	@Cacheable(value = { "sysTimerCache" }, keyGenerator = "cacheKeyGenerator")
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
				super.addJob(t);
			}
		} catch (Exception e) {
			throw new MyException("添加任务失败：" + e.getMessage());
		}
	}

	@CacheEvict(value = { "sysTimerCache" }, allEntries = true, beforeInvocation = true)
	@Override
	public void startJob(CollectionRobotTimer t) {
		try {
			t = get(t.getJobName());
			updateStatusByJobName(t, true);
			super.startJob(t);
		} catch (Exception e) {
			throw new MyException("启动任务失败：：" + e.getMessage());
		}
	}

	@CacheEvict(value = { "sysTimerCache" }, allEntries = true, beforeInvocation = true)
	@Override
	public void stopJob(CollectionRobotTimer t) {
		try {
			t = get(t.getJobName());
			updateStatusByJobName(t, false);
			super.stopJob(t);
		} catch (Exception e) {
			throw new MyException("停止任务失败：" + e.getMessage());
		}
	}

	@CacheEvict(value = { "sysTimerCache" }, allEntries = true, beforeInvocation = true)
	@Override
	public void updateJob(CollectionRobotTimer t) {
		try {
			t.preUpdate();
			collectionRobotTimerDao.update(t);
			super.updateJob(t);
		} catch (Exception e) {
			throw new MyException("更新任务失败：" + e.getMessage());
		}
	}

	@CacheEvict(value = { "sysTimerCache" }, allEntries = true, beforeInvocation = true)
	@Override
	public void deleteJob(CollectionRobotTimer t) {
		try {
			t = get(t.getJobName());
			super.delete(t);
			super.deleteJob(t);
		} catch (Exception e) {
			throw new MyException("删除任务失败：" + e.getMessage());
		}
	}

}
