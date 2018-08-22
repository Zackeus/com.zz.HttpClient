package com.zz.HttpClient.Dao.sys.timer;

import com.zz.HttpClient.Bean.Sys.timer.Timer;
import com.zz.HttpClient.Dao.Basic.CrudDao;

/**
 * 
 * @Title:TimerDao
 * @Description:TODO(定时任务DAO接口)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月16日 上午10:58:26
 */
public interface TimerDao extends CrudDao<Timer> {
	
	public int updateStatusById(Timer timer);
	
	public int updateCronById(Timer timer);
	
}