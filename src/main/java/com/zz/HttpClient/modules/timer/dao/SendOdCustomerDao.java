package com.zz.HttpClient.modules.timer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zz.HttpClient.common.annotation.MyBatisDao;
import com.zz.HttpClient.modules.timer.entity.collectionRobot.CollectionRobotTimer;
import com.zz.HttpClient.modules.timer.entity.collectionRobot.Customer;
import com.zz.HttpClient.modules.timer.entity.collectionRobot.CustomerRepeat;
import com.zz.HttpClient.modules.timer.entity.collectionRobot.ReplaySet;

@MyBatisDao
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
