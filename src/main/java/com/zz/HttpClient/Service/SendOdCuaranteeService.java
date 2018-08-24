package com.zz.HttpClient.Service;

import java.util.List;

import com.zz.HttpClient.Bean.Guarantee;
import com.zz.HttpClient.Bean.ReplaySet;
import com.zz.HttpClient.Bean.Sys.timer.collectionRobot.CollectionRobotTimer;

public interface SendOdCuaranteeService {

	public List<Guarantee> getOverdueGuarantee(CollectionRobotTimer collectionRobotTimer);

	public ReplaySet getReplaySet(CollectionRobotTimer collectionRobotTimer);

	public void insertCollectionInfo(String taskId, String empno, String sendBatch, List<Guarantee> guarantees, 
			CollectionRobotTimer collectionRobotTimer);
	
	public List<Guarantee> getReplayGuarantee(String sendBatch, CollectionRobotTimer collectionRobotTimer);

}
