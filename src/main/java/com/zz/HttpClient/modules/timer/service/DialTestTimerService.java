package com.zz.HttpClient.modules.timer.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zz.HttpClient.common.entity.Page;
import com.zz.HttpClient.common.utils.exception.MyException;
import com.zz.HttpClient.modules.timer.dao.DialTestTimerDao;
import com.zz.HttpClient.modules.timer.entity.DialTestTimer;

/**
 * 
 * @Title:DialTestTimerService
 * @Description:TODO(拨号测试Service)
 * @Company: 
 * @author zhou.zhang
 * @date 2019年1月14日 上午11:18:21
 */
@Service("dialTestTimerService")
public class DialTestTimerService extends BaseTimerService<DialTestTimerDao, DialTestTimer> {
	
	@Cacheable(value = { "sysTimerCache" }, keyGenerator = "cacheKeyGenerator")
	@Override
	public DialTestTimer get(String jobName) {
		DialTestTimer dialTestTimer = super.get(jobName);
		dialTestTimer.initMobileLabels();
		return dialTestTimer;
	}
	
	/**
	 * 
	 * @Title：updateStatusByJobName
	 * @Description: TODO(根据ID更新任务当前状态)
	 * @see：
	 * @param dialTestTimer
	 * @param status
	 * @return
	 */
	public int updateStatusByJobName(DialTestTimer dialTestTimer, boolean status) {
		if (dialTestTimer.isStatus() != status) {
			return dao.updateStatusByJobName(dialTestTimer, status);
		}
		return 0;
	}

	/**
	 * 分页查询
	 */
	@Override
	public Page<DialTestTimer> findPage(Page<DialTestTimer> page, DialTestTimer entity) {
		entity.setPage(page);
		List<DialTestTimer> dialTestTimers = dao.findList(entity);
		for(DialTestTimer dialTestTimer : dialTestTimers) {
			dialTestTimer.initMobileLabels();
		}
		page.setList(dialTestTimers);
		return page;
	}
	
	/**
	 * 添加任务
	 */
	@Override
	public void addJob(DialTestTimer t) {
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
	
	/**
	 * 启动任务
	 */
	@CacheEvict(value = { "sysTimerCache" }, allEntries = true, beforeInvocation = true)
	@Override
	public void startJob(DialTestTimer t) {
		try {
			t = get(t.getJobName());
			updateStatusByJobName(t, true);
			super.startJob(t);
		} catch (Exception e) {
			throw new MyException("启动任务失败：：" + e.getMessage());
		}
	}
	
	/**
	 * 停止任务
	 */
	@CacheEvict(value = { "sysTimerCache" }, allEntries = true, beforeInvocation = true)
	@Override
	public void stopJob(DialTestTimer t) {
		try {
			t = get(t.getJobName());
			updateStatusByJobName(t, false);
			super.stopJob(t);
		} catch (Exception e) {
			throw new MyException("停止任务失败：" + e.getMessage());
		}
	}

	/**
	 * 
	 * @Title：updateJob
	 * @Description: TODO(更新任务)
	 * @see：
	 * @param t
	 */
	@CacheEvict(value = { "sysTimerCache" }, allEntries = true, beforeInvocation = true)
	@Override
	public void updateJob(DialTestTimer t) {
		try {
			t.preUpdate();
			dao.update(t);
			super.updateJob(t);
		} catch (Exception e) {
			throw new MyException("更新任务失败：" + e.getMessage());
		}
	}
	
	/**
	 * 删除任务
	 */
	@CacheEvict(value = { "sysTimerCache" }, allEntries = true, beforeInvocation = true)
	@Override
	public void deleteJob(DialTestTimer t) {
		try {
			t = get(t.getJobName());
			super.delete(t);
			super.deleteJob(t);
		} catch (Exception e) {
			throw new MyException("删除任务失败：" + e.getMessage());
		}
	}
}
