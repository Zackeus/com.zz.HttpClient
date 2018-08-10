package com.zz.HttpClient.Service;

import java.util.List;

import com.zz.HttpClient.Bean.Customer;
import com.zz.HttpClient.Bean.CustomerRepeat;
import com.zz.HttpClient.Bean.ReplaySet;

public interface SendOdCustomerService {

	public List<Customer> getOverdueCustomer();
	
	public void insertCollectionInfo(String taskId, String empno, String sendBatch, List<Customer> customers,
			List<CustomerRepeat> customerRepeats);

	public List<Customer> getCustomerByResult(String result, String sendBatch);

	public List<Customer> getReplayCustomer(String sendBatch, String rtype);

	public ReplaySet getReplaySet(String rtype);

	public List<Customer> getRepeatCollectionInfo(String sendBatch, String rtype);

}
