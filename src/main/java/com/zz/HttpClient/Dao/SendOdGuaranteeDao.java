package com.zz.HttpClient.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zz.HttpClient.Bean.Guarantee;
import com.zz.HttpClient.Bean.ReplaySet;
import com.zz.HttpClient.Bean.Sys.timer.collectionRobot.CollectionRobotTimer;

public interface SendOdGuaranteeDao {
	
	List<Guarantee> getOverdueGuarantee();
	
	List<Guarantee> getOverdueGuaranteeParamter(String sql);
	
	ReplaySet getReplaySet(@Param("collectionRobotTimer") CollectionRobotTimer collectionRobotTimer);
	
	int insertCollectionInfo(@Param("taskId") String taskId, @Param("empno") String empno, @Param("sendBatch") String sendBatch, 
			@Param("guarantees") List<Guarantee> guarantees, @Param("collectionRobotTimer") CollectionRobotTimer collectionRobotTimer);
	
	List<Guarantee> getReplayGuarantee();
	
	List<Guarantee> getReplayGuaranteeParameter(String sql);

}
