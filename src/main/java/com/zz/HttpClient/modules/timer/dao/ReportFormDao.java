package com.zz.HttpClient.modules.timer.dao;

import java.util.List;

import com.zz.HttpClient.common.annotation.MyBatisDao;
import com.zz.HttpClient.modules.timer.entity.collectionRobot.CustomerReportForm;

/**
 * 
 * @Title:ReportFormDao
 * @Description:TODO(报表Dao接口)
 * @Company:
 * @author zhou.zhang
 * @date 2018年12月12日 下午1:18:26
 */
@MyBatisDao
public interface ReportFormDao {

	public List<CustomerReportForm> getOdReportForm(String sendBatch);

}
