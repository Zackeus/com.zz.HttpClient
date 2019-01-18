package com.zz.HttpClient.modules.demo.dao;

import com.zz.HttpClient.common.annotation.MyBatisDao;

@MyBatisDao
public interface TestDao {
	
	public String getFileType(String fileId);
	
}
