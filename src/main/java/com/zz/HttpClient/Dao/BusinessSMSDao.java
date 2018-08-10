package com.zz.HttpClient.Dao;

import org.apache.ibatis.annotations.Param;

import com.zz.HttpClient.Bean.CTC.DetaileReport;
import com.zz.HttpClient.Bean.Msg.BusinessSMS;
import com.zz.HttpClient.Dao.Basic.CrudDao;

public interface BusinessSMSDao extends CrudDao<BusinessSMS> {
	
	String getSerialNoByMsgNo(@Param("msgNo") String msgNo);
	
	int updateRemark(@Param("serialNo") String serialNo);
	
	int updateStatus(@Param("detaileReport") DetaileReport detaileReport);

}
