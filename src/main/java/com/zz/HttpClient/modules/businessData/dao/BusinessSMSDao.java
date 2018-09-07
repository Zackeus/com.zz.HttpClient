package com.zz.HttpClient.modules.businessData.dao;

import org.apache.ibatis.annotations.Param;

import com.zz.HttpClient.common.annotation.MyBatisDao;
import com.zz.HttpClient.common.dao.CrudDao;
import com.zz.HttpClient.modules.businessData.entity.BusinessSMS;
import com.zz.HttpClient.modules.businessData.entity.DetaileReport;

@MyBatisDao
public interface BusinessSMSDao extends CrudDao<BusinessSMS> {
	
	String getSerialNoByMsgNo(@Param("msgNo") String msgNo);
	
	int updateRemark(@Param("serialNo") String serialNo);
	
	int updateStatus(@Param("detaileReport") DetaileReport detaileReport);

}
