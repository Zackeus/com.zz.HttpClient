package com.zz.HttpClient.modules.timer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz.HttpClient.common.config.GlobalConfig;
import com.zz.HttpClient.common.utils.ListUtil;
import com.zz.HttpClient.common.utils.StringUtils;
import com.zz.HttpClient.modules.timer.dao.SendDialTestDao;
import com.zz.HttpClient.modules.timer.entity.DialTestTimer;
import com.zz.HttpClient.modules.timer.entity.collectionRobot.Customer;

/**
 * 
 * @Title:SendDialTestService
 * @Description:TODO(发送催收拨号测试Service)
 * @Company: 
 * @author zhou.zhang
 * @date 2019年1月14日 下午4:42:04
 */
@Service("sendDialTestService")
public class SendDialTestService extends BaseTimerService<SendDialTestDao, DialTestTimer> {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	/**
	 * 
	 * @Title：getDialTestCustomer
	 * @Description: TODO(获取催收拨号测试数据)
	 * @see：
	 * @param dialTestTimer
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> getDialTestCustomer(String sendBatch, DialTestTimer dialTestTimer) {
		if (StringUtils.equals(GlobalConfig.dialTestbatch + 1, sendBatch)) {
			// 第一次抓数据
			dialTestTimer.setMobileLabelsStr("'" + StringUtils.join(dialTestTimer.getMobileLabels(), "','") + "'");
			String sqlcode = sqlSessionFactory .getConfiguration().getMappedStatement("com.zz.HttpClient.modules.timer.dao.SendDialTestDao.getDialTestCustomer")
					.getBoundSql(dialTestTimer).getSql();
			sqlcode = sqlcode.replace("{START_DAY}", dialTestTimer.getStartDay().toString());
			sqlcode = sqlcode.replace("{END_DAY}", dialTestTimer.getEndDay().toString());
			List<Customer> customers = dao.getDialTestCustomerParameter(sqlcode);
			// 数据去重
			return (List<Customer>) ListUtil.getSplitList(customers).get("list");
		} else {
			// 不是第一次 抓取上一批次未接通的数据
			Map<String, Object> paramMaps = new HashMap<>();
			paramMaps.put("sendBatch", GlobalConfig.dialTestbatch + (Integer.valueOf(StringUtils.split(sendBatch, "-")[1]) - 1));
			paramMaps.put("dialTestTimer", dialTestTimer);
			String sqlcode = sqlSessionFactory .getConfiguration().getMappedStatement("com.zz.HttpClient.modules.timer.dao.SendDialTestDao.getReplayDialTestCustomer")
					.getBoundSql(paramMaps).getSql();
			sqlcode = sqlcode.replace("{START_DAY}", dialTestTimer.getStartDay().toString());
			sqlcode = sqlcode.replace("{END_DAY}", dialTestTimer.getEndDay().toString());
			return dao.getReplayDialTestCustomerParameter(sqlcode);
		}
	}
	
	/**
	 * 
	 * @Title：insertInfo
	 * @Description: TODO(插入催收拨号测试记录)
	 * @see：
	 * @param taskId 任务编号
	 * @param empno 执行者
	 * @param sendBatch 发送标签
	 * @param customers 数据体
	 * @param dialTestTimer 定时任务类
	 */
	public void insertInfo(String taskId, String empno, String sendBatch, List<Customer> customers, DialTestTimer dialTestTimer) {
		if (customers.size() > 100) {
			for (List<Customer> customersBySplite : ListUtil.listSplite(customers, (customers.size() / 100) + 1)) {
				// List分批插入 SqlServer 对语句的条数和参数的数量都有限制，分别是 1000 和 2100。
				dao.insertInfo(taskId, empno, sendBatch, customersBySplite, dialTestTimer);
			}
		} else {
			dao.insertInfo(taskId, empno, sendBatch, customers, dialTestTimer);
		}
	}
	
	/**
	 * 
	 * @Title：getSendBeanch
	 * @Description: TODO(查询最近的发送标签)
	 * @see：
	 * @param batch
	 * @return
	 */
	public String getSendBeanch(String batch) {
		return dao.getSendBeanch(batch);
	}

}
