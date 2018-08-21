package com.zz.HttpClient.Service.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zz.HttpClient.Bean.Sys.timer.Timer;
import com.zz.HttpClient.Dao.sys.TimerDao;
import com.zz.HttpClient.Service.Basic.CrudService;

/**
 * 
 * @Title:TimerService
 * @Description:TODO(定时任务Service)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月16日 上午10:59:29
 */
@Service("timerService")
public class TimerService extends CrudService<TimerDao, Timer> {
	
	@Autowired
	TimerDao timerDao;
	
	@Cacheable(value = {"sysTimerCache"}, key="#id")
	@Override
	public Timer get(String id) {
		return super.get(id);
	}
	
	/**
	 * 
	 * @Title：updateStatusById
	 * @Description: TODO(根据ID更新任务当前状态)
	 * @see：
	 * @param timer
	 * @return
	 */
	@CacheEvict(value = {"sysTimerCache"}, key="#timer.id")
	public int updateStatusById(Timer timer) {
		return timerDao.updateStatusById(timer);
	}
	
	/**
	 * 
	 * @Title：updateCronById
	 * @Description: TODO(根据ID更新定时策略)
	 * @see：
	 * @param timer
	 * @return
	 */
	@CacheEvict(value = {"sysTimerCache"}, key="#timer.id")
	public int updateCronById(Timer timer) {
		return timerDao.updateCronById(timer);
	}
	
}
