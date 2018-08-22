package com.zz.HttpClient.Dao.sys;

import java.util.List;

import com.zz.HttpClient.Bean.Sys.Dict;
import com.zz.HttpClient.Dao.Basic.CrudDao;

/**
 * 
 * @Title:DictDao
 * @Description:TODO(字典DAO接口)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月22日 下午3:06:11
 */
public interface DictDao extends CrudDao<Dict> {
	
	public List<Dict> findListByType(String type);

}
