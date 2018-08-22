package com.zz.HttpClient.Service.sys.timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zz.HttpClient.Bean.Sys.timer.collectionRobot.CollectionRobotTimer;
import com.zz.HttpClient.Dao.sys.timer.CollectionRobotTimerDao;
import com.zz.HttpClient.Service.Basic.CrudService;

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
	CollectionRobotTimerDao collectionRobotTimerDao;
	
	@Cacheable(value = {"sysTimerCache"}, key="#jobName")
	@Override
	public CollectionRobotTimer get(String jobName) {
		return super.get(jobName);
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

}
