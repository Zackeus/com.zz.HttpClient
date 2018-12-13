package com.zz.HttpClient.modules.timer.dao;

import org.apache.ibatis.annotations.Param;

import com.zz.HttpClient.common.annotation.MyBatisDao;
import com.zz.HttpClient.common.dao.CrudDao;
import com.zz.HttpClient.modules.timer.entity.CommonTimer;

/**
 * 
 * @Title:CommonTimerDao
 * @Description:TODO(普通排程 Dao接口)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年12月12日 下午3:45:28
 */
@MyBatisDao
public interface CommonTimerDao extends CrudDao<CommonTimer> {
	
	public int updateStatusByJobName(@Param("commonTimer") CommonTimer commonTimer, 
			@Param("status") boolean status);
	
	public int updateRes(CommonTimer commonTimer);
	
}
