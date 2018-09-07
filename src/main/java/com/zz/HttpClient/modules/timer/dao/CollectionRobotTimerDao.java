package com.zz.HttpClient.modules.timer.dao;

import org.apache.ibatis.annotations.Param;

import com.zz.HttpClient.common.annotation.MyBatisDao;
import com.zz.HttpClient.common.dao.CrudDao;
import com.zz.HttpClient.modules.timer.entity.collectionRobot.CollectionRobotTimer;

/**
 * 
 * @Title:CollectionRobotDao
 * @Description:TODO(催收机器人定时任务DAO接口)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月21日 下午2:08:41
 */
@MyBatisDao
public interface CollectionRobotTimerDao extends CrudDao<CollectionRobotTimer> {
	
	public int updateStatusByJobName(@Param("collectionRobotTimer") CollectionRobotTimer collectionRobotTimer, 
			@Param("status") boolean status);

}
