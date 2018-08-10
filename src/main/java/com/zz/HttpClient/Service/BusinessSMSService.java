package com.zz.HttpClient.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz.HttpClient.Bean.Msg.BusinessSMS;
import com.zz.HttpClient.Dao.BusinessSMSDao;
import com.zz.HttpClient.Service.Basic.CrudService;

/**
 * 
 * @Title:BusinessSMSService
 * @Description:TODO(业务短信Service)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月9日 上午9:39:20
 */
@Service("businessSMSService")
public class BusinessSMSService extends CrudService<BusinessSMSDao, BusinessSMS> {
	
	@SuppressWarnings("unused")
	@Autowired
	private BusinessSMSDao businessSMSDao;

}
