package com.zz.HttpClient.Service;

import java.util.List;

import com.zz.HttpClient.Bean.Customer;
import com.zz.HttpClient.Bean.CustomerRepeat;
import com.zz.HttpClient.Bean.ReplaySet;
import com.zz.HttpClient.Bean.Sys.timer.collectionRobot.CollectionRobotTimer;

public interface SendOdCustomerService {

	public List<Customer> getOverdueCustomer(CollectionRobotTimer collectionRobotTimer);
	
	public void insertCollectionInfo(String taskId, String empno, String sendBatch, List<Customer> customers,
			List<CustomerRepeat> customerRepeats, CollectionRobotTimer collectionRobotTimer);

	public List<Customer> getCustomerByResult(String result, String sendBatch);

	public List<Customer> getReplayCustomer(String sendBatch, CollectionRobotTimer collectionRobotTimer);

	public ReplaySet getReplaySet(CollectionRobotTimer collectionRobotTimer);

	public List<Customer> getRepeatCollectionInfo(String sendBatch, CollectionRobotTimer collectionRobotTimer);

}
