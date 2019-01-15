package com.zz.HttpClient.modules.timer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zz.HttpClient.common.annotation.MyBatisDao;
import com.zz.HttpClient.common.dao.CrudDao;
import com.zz.HttpClient.modules.timer.entity.DialTestTimer;
import com.zz.HttpClient.modules.timer.entity.collectionRobot.Customer;

/**
 * 
 * @Title:SendDialTestDao
 * @Description:TODO(发送催收拨号测试Dao接口)
 * @Company: 
 * @author zhou.zhang
 * @date 2019年1月14日 下午4:38:57
 */
@MyBatisDao
public interface SendDialTestDao extends CrudDao<DialTestTimer> {
	
	List<Customer> getDialTestCustomer(DialTestTimer dialTestTimer);
	
	List<Customer> getDialTestCustomerParameter(String sql);
	
	List<Customer> getReplayDialTestCustomer(@Param("sendBatch") String sendBatch, @Param("dialTestTimer") DialTestTimer dialTestTimer);
	
	List<Customer> getReplayDialTestCustomerParameter(String sql);
	
	int insertInfo(@Param("taskId") String taskId, @Param("empno") String empno, @Param("sendBatch") String sendBatch, 
			@Param("customers") List<Customer> customers, @Param("dialTestTimer") DialTestTimer dialTestTimer);
	
	String getSendBeanch(String batch);

}
