package com.zz.HttpClient.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zz.HttpClient.Bean.Customer;
import com.zz.HttpClient.Bean.CustomerRepeat;
import com.zz.HttpClient.Bean.ReplaySet;
import com.zz.HttpClient.Dao.SendOdCustomerDao;
import com.zz.HttpClient.Service.SendOdCustomerService;
import com.zz.HttpClient.Util.ListUtil;
import com.zz.HttpClient.Util.ObjectUtils;

@Service("sendOdCustomerService")
@Transactional(readOnly = true)
public class SendOdCustomerImpl implements SendOdCustomerService {

	@Autowired
	private SendOdCustomerDao sendOdCustomerDao;

	public List<Customer> getOverdueCustomer() {
		return sendOdCustomerDao.getOverdueCustomer();
	}
	
	/**
	 * 插入催收数据提交记录
	 */
	public void insertCollectionInfo(String taskId, String empno, String sendBatch, List<Customer> customers,
			List<CustomerRepeat> customerRepeats) {
		if (customers.size() > 100) {
			for (List<Customer> customersBySplite : ListUtil.listSplite(customers, (customers.size() / 100) + 1)) {
				// List分批插入 SqlServer 对语句的条数和参数的数量都有限制，分别是 1000 和 2100。
				sendOdCustomerDao.insertCollectionInfo(taskId, empno, sendBatch, customersBySplite);
			}
		} else {
			sendOdCustomerDao.insertCollectionInfo(taskId, empno, sendBatch, customers);
		}

		if (!ObjectUtils.isEmpty(customerRepeats)) {
			if (customerRepeats.size() > 100) {
				for (List<CustomerRepeat> customerRepeatsBySplite : ListUtil.listSplite(customerRepeats,
						(customerRepeats.size() / 100) + 1)) {
					// List分批插入 SqlServer 对语句的条数和参数的数量都有限制，分别是 1000 和 2100。
					sendOdCustomerDao.insertRepeatCollectionInfo(taskId, empno, sendBatch, customerRepeatsBySplite);
				}
			} else {
				sendOdCustomerDao.insertRepeatCollectionInfo(taskId, empno, sendBatch, customerRepeats);
			}
		}
	}

	public List<Customer> getCustomerByResult(String result, String sendBatch) {
		return sendOdCustomerDao.getCustomerByResult(result, sendBatch);
	}

	public List<Customer> getReplayCustomer(String sendBatch, String rtype) {
		return sendOdCustomerDao.getReplayCustomer(sendBatch, rtype);
	}

	public ReplaySet getReplaySet(String rtype) {
		return sendOdCustomerDao.getReplaySet(rtype);
	}

	public List<Customer> getRepeatCollectionInfo(String sendBatch, String rtype) {
		return sendOdCustomerDao.getRepeatCollectionInfo(sendBatch, rtype);
	}
}
