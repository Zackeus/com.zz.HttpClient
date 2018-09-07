package com.zz.HttpClient.modules.timer.service;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zz.HttpClient.common.utils.ListUtil;
import com.zz.HttpClient.common.utils.ObjectUtils;
import com.zz.HttpClient.modules.timer.dao.SendOdCustomerDao;
import com.zz.HttpClient.modules.timer.entity.collectionRobot.CollectionRobotTimer;
import com.zz.HttpClient.modules.timer.entity.collectionRobot.Customer;
import com.zz.HttpClient.modules.timer.entity.collectionRobot.CustomerRepeat;
import com.zz.HttpClient.modules.timer.entity.collectionRobot.ReplaySet;

@Service("sendOdCustomerService")
@Transactional(readOnly = true)
public class SendOdCustomerImpl implements SendOdCustomerService {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	private SendOdCustomerDao sendOdCustomerDao;
	
	public List<Customer> getOverdueCustomer(CollectionRobotTimer collectionRobotTimer) {
		String sqlcode = sqlSessionFactory .getConfiguration().getMappedStatement("com.zz.HttpClient.Dao.SendOdCustomerDao.getOverdueCustomer")
				.getBoundSql(null).getSql();
		sqlcode = sqlcode.replace("{START_DAY}", collectionRobotTimer.getStartDay().toString());
		sqlcode = sqlcode.replace("{END_DAY}", collectionRobotTimer.getEndDay().toString());
		return sendOdCustomerDao.getOverdueCustomerParameter(sqlcode);
	}
	
	/**
	 * 插入催收数据提交记录
	 */
	public void insertCollectionInfo(String taskId, String empno, String sendBatch, List<Customer> customers,
			List<CustomerRepeat> customerRepeats, CollectionRobotTimer collectionRobotTimer) {
		if (customers.size() > 100) {
			for (List<Customer> customersBySplite : ListUtil.listSplite(customers, (customers.size() / 100) + 1)) {
				// List分批插入 SqlServer 对语句的条数和参数的数量都有限制，分别是 1000 和 2100。
				sendOdCustomerDao.insertCollectionInfo(taskId, empno, sendBatch, customersBySplite, collectionRobotTimer);
			}
		} else {
			sendOdCustomerDao.insertCollectionInfo(taskId, empno, sendBatch, customers, collectionRobotTimer);
		}

		if (!ObjectUtils.isEmpty(customerRepeats)) {
			if (customerRepeats.size() > 100) {
				for (List<CustomerRepeat> customerRepeatsBySplite : ListUtil.listSplite(customerRepeats,
						(customerRepeats.size() / 100) + 1)) {
					// List分批插入 SqlServer 对语句的条数和参数的数量都有限制，分别是 1000 和 2100。
					sendOdCustomerDao.insertRepeatCollectionInfo(taskId, empno, sendBatch, customerRepeatsBySplite, collectionRobotTimer);
				}
			} else {
				sendOdCustomerDao.insertRepeatCollectionInfo(taskId, empno, sendBatch, customerRepeats, collectionRobotTimer);
			}
		}
	}

	public List<Customer> getCustomerByResult(String result, String sendBatch) {
		return sendOdCustomerDao.getCustomerByResult(result, sendBatch);
	}

	public List<Customer> getReplayCustomer(String sendBatch, CollectionRobotTimer collectionRobotTimer) {
		String sqlcode = sqlSessionFactory .getConfiguration().getMappedStatement("com.zz.HttpClient.Dao.SendOdCustomerDao.getReplayCustomer")
				.getBoundSql(null).getSql();
		sqlcode = sqlcode.replace("{START_DAY}", collectionRobotTimer.getStartDay().toString());
		sqlcode = sqlcode.replace("{END_DAY}", collectionRobotTimer.getEndDay().toString());
		sqlcode = sqlcode.replace("{sendBatch}", sendBatch);
		sqlcode = sqlcode.replace("{collectionRobotTimer.jobName}", collectionRobotTimer.getJobName());
		return sendOdCustomerDao.getReplayCustomerParameter(sqlcode);
	}

	public ReplaySet getReplaySet(CollectionRobotTimer collectionRobotTimer) {
		return sendOdCustomerDao.getReplaySet(collectionRobotTimer);
	}

	public List<Customer> getRepeatCollectionInfo(String sendBatch, CollectionRobotTimer collectionRobotTimer) {
		return sendOdCustomerDao.getRepeatCollectionInfo(sendBatch, collectionRobotTimer);
	}
}
