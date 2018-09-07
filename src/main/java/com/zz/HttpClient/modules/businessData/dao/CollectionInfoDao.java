package com.zz.HttpClient.modules.businessData.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zz.HttpClient.common.annotation.MyBatisDao;
import com.zz.HttpClient.modules.businessData.entity.CollectionCallData;
import com.zz.HttpClient.modules.businessData.entity.CollectionResult;

@MyBatisDao
public interface CollectionInfoDao {
	
	int insertCollectionResult(@Param("collectionResults") List<CollectionResult> collectionResults);
	
	int insertCollectionCallData(@Param("taskDataId") Long taskDataId, @Param("collectionCallDatas") List<CollectionCallData> collectionCallDatas);

}
