package com.zz.HttpClient.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zz.HttpClient.Bean.Guarantee;
import com.zz.HttpClient.Bean.ReplaySet;
import com.zz.HttpClient.Dao.SendOdGuaranteeDao;
import com.zz.HttpClient.Service.SendOdCuaranteeService;
import com.zz.HttpClient.Util.ListUtil;

@Service("sendOdCuaranteeService")
@Transactional(readOnly = true)
public class SendOdCuaranteeImpl implements SendOdCuaranteeService {
	
	@Autowired
	private SendOdGuaranteeDao sendOdGuaranteeDao;

	@Override
	public List<Guarantee> getOverdueGuarantee() {
		return sendOdGuaranteeDao.getOverdueGuarantee();
	}

	@Override
	public ReplaySet getReplaySet(String rtype) {
		return sendOdGuaranteeDao.getReplaySet(rtype);
	}

	@Override
	public void insertCollectionInfo(String taskId, String empno, String sendBatch, List<Guarantee> guarantees) {
		if (guarantees.size() > 100) {
			for (List<Guarantee> guaranteesBySplite : ListUtil.listSplite(guarantees, (guarantees.size() / 100) + 1)) {
				// List分批插入 SqlServer 对语句的条数和参数的数量都有限制，分别是 1000 和 2100。
				sendOdGuaranteeDao.insertCollectionInfo(taskId, empno, sendBatch, guaranteesBySplite);
			}
		} else {
			sendOdGuaranteeDao.insertCollectionInfo(taskId, empno, sendBatch, guarantees);
		}
	}

	@Override
	public List<Guarantee> getReplayGuarantee(String sendBatch) {
		return sendOdGuaranteeDao.getReplayGuarantee(sendBatch);
	}

}
