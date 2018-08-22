package com.zz.HttpClient.Dao.sys.timer;

import org.apache.ibatis.annotations.Param;

import com.zz.HttpClient.Bean.Sys.timer.collectionRobot.CollectionRobotTimer;
import com.zz.HttpClient.Dao.Basic.CrudDao;

/**
 * 
 * @Title:CollectionRobotDao
 * @Description:TODO(催收机器人定时任务DAO接口)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月21日 下午2:08:41
 */
public interface CollectionRobotTimerDao extends CrudDao<CollectionRobotTimer> {
	
	public int updateStatusByJobName(@Param("collectionRobotTimer") CollectionRobotTimer collectionRobotTimer, 
			@Param("status") boolean status);

}
