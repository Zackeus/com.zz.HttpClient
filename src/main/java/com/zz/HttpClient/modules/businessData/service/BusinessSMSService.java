package com.zz.HttpClient.modules.businessData.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz.HttpClient.common.service.CrudService;
import com.zz.HttpClient.modules.businessData.dao.BusinessSMSDao;
import com.zz.HttpClient.modules.businessData.entity.BusinessSMS;

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
