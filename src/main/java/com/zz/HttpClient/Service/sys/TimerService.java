package com.zz.HttpClient.Service.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz.HttpClient.Bean.Sys.Timer;
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
	
	/**
	 * 
	 * @Title：updateStatusById
	 * @Description: TODO(根据ID更新任务当前状态)
	 * @see：
	 * @param timer
	 * @return
	 */
	public int updateStatusById(Timer timer) {
		return timerDao.updateStatusById(timer);
	}
	
}
