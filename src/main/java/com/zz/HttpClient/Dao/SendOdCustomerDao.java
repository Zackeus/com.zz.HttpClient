package com.zz.HttpClient.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zz.HttpClient.Bean.Customer;
import com.zz.HttpClient.Bean.CustomerRepeat;
import com.zz.HttpClient.Bean.ReplaySet;

public interface SendOdCustomerDao {

	List<Customer> getOverdueCustomer();
	
	int insertCollectionInfo(@Param("taskId") String taskId, @Param("empno") String empno,
			@Param("sendBatch") String sendBatch, @Param("customers") List<Customer> customers);

	int insertRepeatCollectionInfo(@Param("taskId") String taskId, @Param("empno") String empno,
			@Param("sendBatch") String sendBatch, @Param("customerRepeats") List<CustomerRepeat> customerRepeats);
	
	List<Customer> getRepeatCollectionInfo(@Param("sendBatch") String sendBatch, @Param("rtype") String rtype);
	
	List<Customer> getCustomerByResult(@Param("result") String result, @Param("sendBatch") String sendBatch);
	
	List<Customer> getReplayCustomer(@Param("sendBatch") String sendBatch, @Param("rtype") String rtype);
	
	ReplaySet getReplaySet(@Param("rtype") String rtype);
}
