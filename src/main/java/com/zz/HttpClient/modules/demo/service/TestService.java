package com.zz.HttpClient.modules.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz.HttpClient.modules.demo.dao.TestDao;

@Service("testService")
public class TestService {
	
	@Autowired
	private TestDao testDao;
	
	/**
	 * 
	 * @Title：getFileType
	 * @Description: TODO(查询图片种类 用于AI训练)
	 * @see：
	 * @param fileId
	 * @return
	 */
	public String getFileType(String fileId) {
		return testDao.getFileType(fileId);
	}

}
