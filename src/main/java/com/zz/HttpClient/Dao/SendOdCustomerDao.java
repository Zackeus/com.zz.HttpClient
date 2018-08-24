package com.zz.HttpClient.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zz.HttpClient.Bean.Customer;
import com.zz.HttpClient.Bean.CustomerRepeat;
import com.zz.HttpClient.Bean.ReplaySet;
import com.zz.HttpClient.Bean.Sys.timer.collectionRobot.CollectionRobotTimer;

public interface SendOdCustomerDao {

	List<Customer> getOverdueCustomer();
	
	List<Customer> getOverdueCustomerParameter(String sql);
	
	int insertCollectionInfo(@Param("taskId") String taskId, @Param("empno") String empno, @Param("sendBatch") String sendBatch, 
			@Param("customers") List<Customer> customers,  @Param("collectionRobotTimer") CollectionRobotTimer collectionRobotTimer);

	int insertRepeatCollectionInfo(@Param("taskId") String taskId, @Param("empno") String empno, @Param("sendBatch") String sendBatch, 
			@Param("customerRepeats") List<CustomerRepeat> customerRepeats, @Param("collectionRobotTimer") CollectionRobotTimer collectionRobotTimer);
	
	List<Customer> getRepeatCollectionInfo(@Param("sendBatch") String sendBatch, @Param("collectionRobotTimer") CollectionRobotTimer collectionRobotTimer);
	
	List<Customer> getCustomerByResult(@Param("result") String result, @Param("sendBatch") String sendBatch);
	
	List<Customer> getReplayCustomer();
	
	List<Customer> getReplayCustomerParameter(String sql);
	
	ReplaySet getReplaySet(@Param("collectionRobotTimer") CollectionRobotTimer collectionRobotTimer);
}
