package com.zz.HttpClient.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zz.HttpClient.Dao.SendOdGuaranteeDao;
import com.zz.HttpClient.Service.SendOdCuaranteeService;
import com.zz.HttpClient.Util.ListUtil;
import com.zz.HttpClient.Bean.Guarantee;
import com.zz.HttpClient.Bean.ReplaySet;
import com.zz.HttpClient.Bean.Sys.timer.collectionRobot.CollectionRobotTimer;

@Service("sendOdCuaranteeService")
@Transactional(readOnly = true)
public class SendOdCuaranteeImpl implements SendOdCuaranteeService {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	private SendOdGuaranteeDao sendOdGuaranteeDao;

	@Override
	public List<Guarantee> getOverdueGuarantee(CollectionRobotTimer collectionRobotTimer) {
		String sqlcode = sqlSessionFactory .getConfiguration().getMappedStatement("com.zz.HttpClient.Dao.SendOdGuaranteeDao.getOverdueGuarantee")
				.getBoundSql(null).getSql();
		sqlcode = sqlcode.replace("{START_DAY}", collectionRobotTimer.getStartDay().toString());
		sqlcode = sqlcode.replace("{END_DAY}", collectionRobotTimer.getEndDay().toString());
		return sendOdGuaranteeDao.getOverdueGuaranteeParamter(sqlcode);
	}

	@Override
	public ReplaySet getReplaySet(CollectionRobotTimer collectionRobotTimer) {
		return sendOdGuaranteeDao.getReplaySet(collectionRobotTimer);
	}

	@Override
	public void insertCollectionInfo(String taskId, String empno, String sendBatch, List<Guarantee> guarantees, 
			CollectionRobotTimer collectionRobotTimer) {
		if (guarantees.size() > 100) {
			for (List<Guarantee> guaranteesBySplite : ListUtil.listSplite(guarantees, (guarantees.size() / 100) + 1)) {
				// List分批插入 SqlServer 对语句的条数和参数的数量都有限制，分别是 1000 和 2100。
				sendOdGuaranteeDao.insertCollectionInfo(taskId, empno, sendBatch, guaranteesBySplite, collectionRobotTimer);
			}
		} else {
			sendOdGuaranteeDao.insertCollectionInfo(taskId, empno, sendBatch, guarantees, collectionRobotTimer);
		}
	}

	@Override
	public List<Guarantee> getReplayGuarantee(String sendBatch, CollectionRobotTimer collectionRobotTimer) {
		String sqlcode = sqlSessionFactory .getConfiguration().getMappedStatement("com.zz.HttpClient.Dao.SendOdGuaranteeDao.getReplayGuarantee")
				.getBoundSql(null).getSql();
		sqlcode = sqlcode.replace("{START_DAY}", collectionRobotTimer.getStartDay().toString());
		sqlcode = sqlcode.replace("{END_DAY}", collectionRobotTimer.getEndDay().toString());
		sqlcode = sqlcode.replace("{sendBatch}", sendBatch);
		sqlcode = sqlcode.replace("{collectionRobotTimer.jobName}", collectionRobotTimer.getJobName());
		return sendOdGuaranteeDao.getReplayGuaranteeParameter(sqlcode);
	}

}
