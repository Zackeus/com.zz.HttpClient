package com.zz.HttpClient.modules.timer.service;

import java.util.List;

import com.zz.HttpClient.modules.timer.entity.collectionRobot.CollectionRobotTimer;
import com.zz.HttpClient.modules.timer.entity.collectionRobot.Customer;
import com.zz.HttpClient.modules.timer.entity.collectionRobot.CustomerRepeat;
import com.zz.HttpClient.modules.timer.entity.collectionRobot.ReplaySet;

public interface SendOdCustomerService {

	public List<Customer> getOverdueCustomer(CollectionRobotTimer collectionRobotTimer);
	
	public void insertCollectionInfo(String taskId, String empno, String sendBatch, List<Customer> customers,
			List<CustomerRepeat> customerRepeats, CollectionRobotTimer collectionRobotTimer);

	public List<Customer> getCustomerByResult(String result, String sendBatch);

	public List<Customer> getReplayCustomer(String sendBatch, CollectionRobotTimer collectionRobotTimer);

	public ReplaySet getReplaySet(CollectionRobotTimer collectionRobotTimer);

	public List<Customer> getRepeatCollectionInfo(String sendBatch, CollectionRobotTimer collectionRobotTimer);

}
