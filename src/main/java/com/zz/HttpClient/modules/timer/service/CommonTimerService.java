package com.zz.HttpClient.modules.timer.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zz.HttpClient.common.utils.exception.MyException;
import com.zz.HttpClient.modules.timer.dao.CommonTimerDao;
import com.zz.HttpClient.modules.timer.entity.CommonTimer;

/**
 * 
 * @Title:CommonTimerService
 * @Description:TODO(普通定时排程Service)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年12月12日 下午3:48:02
 */
@Service("commonTimerService")
public class CommonTimerService extends BaseTimerService<CommonTimerDao, CommonTimer> {
	
	@Cacheable(value = { "sysTimerCache" }, keyGenerator = "cacheKeyGenerator")
	@Override
	public CommonTimer get(String jobName) {
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
	public int updateStatusByJobName(CommonTimer t, boolean status) {
		if (t.isStatus() != status) {
			return dao.updateStatusByJobName(t, status);
		}
		return 0;
	}
	
	@Override
	public void addJob(CommonTimer t) {
		try {
			t.setJobGroupName(JOB_GROUP_NAME);
			t.preInsert();
			dao.insert(t);

			if (t.isStatus()) {
				super.addJob(t);
			}
		} catch (Exception e) {
			throw new MyException("添加任务失败：" + e.getMessage());
		}
	}
	
	@CacheEvict(value = { "sysTimerCache" }, allEntries = true, beforeInvocation = true)
	@Override
	public void startJob(CommonTimer t) {
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
	public void stopJob(CommonTimer t) {
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
	public void updateJob(CommonTimer t) {
		try {
			t.preUpdate();
			dao.update(t);
			super.updateJob(t);
		} catch (Exception e) {
			throw new MyException("更新任务失败：" + e.getMessage());
		}
	}
	
	@CacheEvict(value = { "sysTimerCache" }, allEntries = true, beforeInvocation = true)
	@Override
	public void deleteJob(CommonTimer t) {
		try {
			t = get(t.getJobName());
			super.delete(t);
			super.deleteJob(t);
		} catch (Exception e) {
			throw new MyException("删除任务失败：" + e.getMessage());
		}
	}

}
