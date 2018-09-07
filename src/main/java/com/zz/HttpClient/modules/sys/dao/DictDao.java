package com.zz.HttpClient.modules.sys.dao;

import java.util.List;

import com.zz.HttpClient.common.annotation.MyBatisDao;
import com.zz.HttpClient.common.dao.CrudDao;
import com.zz.HttpClient.modules.sys.entity.Dict;

/**
 * 
 * @Title:DictDao
 * @Description:TODO(字典DAO接口)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月22日 下午3:06:11
 */
@MyBatisDao
public interface DictDao extends CrudDao<Dict> {
	
	public List<Dict> findListByType(String type);

}
