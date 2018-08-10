package com.zz.HttpClient.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface IpWhileDao {
	
	List<String> getIpWhileLists(@Param("coId") String coId);
	
}
