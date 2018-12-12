package com.zz.HttpClient.modules.timer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zz.HttpClient.modules.timer.dao.ReportFormDao;
import com.zz.HttpClient.modules.timer.entity.collectionRobot.CustomerReportForm;

/**
 * 
 * @Title:ReportFormService
 * @Description:TODO(报表Service)
 * @Company:
 * @author zhou.zhang
 * @date 2018年12月12日 下午1:20:53
 */
@Service("reportFormService")
@Transactional(readOnly = true)
public class ReportFormService {

	@Autowired
	private ReportFormDao reportFormDao;
	
	/**
	 * 
	 * @Title：getOdReportForm
	 * @Description: TODO(根据发送批次标签查询昨日催收报表数据)
	 * @see：
	 * @param sendBatch
	 * @return
	 */
	public List<CustomerReportForm> getOdReportForm(String sendBatch) {
		return this.reportFormDao.getOdReportForm(sendBatch);
	}

}
