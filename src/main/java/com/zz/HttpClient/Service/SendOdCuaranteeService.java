package com.zz.HttpClient.Service;

import java.util.List;

import com.zz.HttpClient.Bean.Guarantee;
import com.zz.HttpClient.Bean.ReplaySet;

public interface SendOdCuaranteeService {

	public List<Guarantee> getOverdueGuarantee();

	public ReplaySet getReplaySet(String rtype);

	public void insertCollectionInfo(String taskId, String empno, String sendBatch, List<Guarantee> guarantees);
	
	public List<Guarantee> getReplayGuarantee(String sendBatch);

}
