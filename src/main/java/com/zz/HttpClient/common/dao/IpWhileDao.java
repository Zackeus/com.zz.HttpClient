package com.zz.HttpClient.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zz.HttpClient.common.annotation.MyBatisDao;

@MyBatisDao
public interface IpWhileDao {
	
	List<String> getIpWhileLists(@Param("coId") String coId);
	
}
