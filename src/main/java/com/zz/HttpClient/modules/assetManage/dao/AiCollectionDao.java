package com.zz.HttpClient.modules.assetManage.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.zz.HttpClient.common.annotation.MyBatisDao;
import com.zz.HttpClient.common.dao.CrudDao;
import com.zz.HttpClient.modules.assetManage.entity.AiCollectionInfo;
import com.zz.HttpClient.modules.assetManage.entity.AiCollectionResult;

/**
 * 
 * @Title:AiCollectionDao
 * @Description:TODO(智能催收Dao接口)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年9月10日 下午4:25:24
 */
@MyBatisDao
public interface AiCollectionDao extends CrudDao<AiCollectionInfo> {
	
	public AiCollectionResult connectionRateStatisticsByTime(@Param("date") Date date, @Param("hour") Integer hour);

}
