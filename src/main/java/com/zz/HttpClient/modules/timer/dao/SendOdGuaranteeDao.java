package com.zz.HttpClient.modules.timer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zz.HttpClient.common.annotation.MyBatisDao;
import com.zz.HttpClient.modules.timer.entity.collectionRobot.CollectionRobotTimer;
import com.zz.HttpClient.modules.timer.entity.collectionRobot.Guarantee;
import com.zz.HttpClient.modules.timer.entity.collectionRobot.ReplaySet;

@MyBatisDao
public interface SendOdGuaranteeDao {
	
	List<Guarantee> getOverdueGuarantee();
	
	List<Guarantee> getOverdueGuaranteeParamter(String sql);
	
	ReplaySet getReplaySet(@Param("collectionRobotTimer") CollectionRobotTimer collectionRobotTimer);
	
	int insertCollectionInfo(@Param("taskId") String taskId, @Param("empno") String empno, @Param("sendBatch") String sendBatch, 
			@Param("guarantees") List<Guarantee> guarantees, @Param("collectionRobotTimer") CollectionRobotTimer collectionRobotTimer);
	
	List<Guarantee> getReplayGuarantee();
	
	List<Guarantee> getReplayGuaranteeParameter(String sql);

}
