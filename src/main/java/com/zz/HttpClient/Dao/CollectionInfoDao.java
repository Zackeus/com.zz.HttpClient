package com.zz.HttpClient.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zz.HttpClient.Bean.CollectionCallData;
import com.zz.HttpClient.Bean.CollectionResult;

public interface CollectionInfoDao {
	
	int insertCollectionResult(@Param("collectionResults") List<CollectionResult> collectionResults);
	
	int insertCollectionCallData(@Param("taskDataId") Long taskDataId, @Param("collectionCallDatas") List<CollectionCallData> collectionCallDatas);

}
