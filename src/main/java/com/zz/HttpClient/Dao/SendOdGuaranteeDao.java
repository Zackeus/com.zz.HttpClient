package com.zz.HttpClient.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zz.HttpClient.Bean.Guarantee;
import com.zz.HttpClient.Bean.ReplaySet;

public interface SendOdGuaranteeDao {
	
	List<Guarantee> getOverdueGuarantee();
	
	ReplaySet getReplaySet(@Param("rtype") String rtype);
	
	int insertCollectionInfo(@Param("taskId") String taskId, @Param("empno") String empno,
			@Param("sendBatch") String sendBatch, @Param("guarantees") List<Guarantee> guarantees);
	
	List<Guarantee> getReplayGuarantee(@Param("sendBatch") String sendBatch);

}
