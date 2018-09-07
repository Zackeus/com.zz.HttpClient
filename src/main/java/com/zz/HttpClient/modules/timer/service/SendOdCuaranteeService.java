package com.zz.HttpClient.modules.timer.service;

import java.util.List;

import com.zz.HttpClient.modules.timer.entity.collectionRobot.CollectionRobotTimer;
import com.zz.HttpClient.modules.timer.entity.collectionRobot.Guarantee;
import com.zz.HttpClient.modules.timer.entity.collectionRobot.ReplaySet;

public interface SendOdCuaranteeService {

	public List<Guarantee> getOverdueGuarantee(CollectionRobotTimer collectionRobotTimer);

	public ReplaySet getReplaySet(CollectionRobotTimer collectionRobotTimer);

	public void insertCollectionInfo(String taskId, String empno, String sendBatch, List<Guarantee> guarantees, 
			CollectionRobotTimer collectionRobotTimer);
	
	public List<Guarantee> getReplayGuarantee(String sendBatch, CollectionRobotTimer collectionRobotTimer);

}
