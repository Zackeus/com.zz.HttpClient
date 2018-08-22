package com.zz.HttpClient.Service.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zz.HttpClient.Bean.Sys.Dict;
import com.zz.HttpClient.Dao.sys.DictDao;
import com.zz.HttpClient.Service.Basic.CrudService;

/**
 * 
 * @Title:DictService
 * @Description:TODO(字典service)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月22日 下午3:08:57
 */
@Service("dictService")
public class DictService extends CrudService<DictDao, Dict> {
	
	@Autowired
	private DictDao dictDao;
	
	@Cacheable(value = {"sysDictCache"}, key="#type")
	public List<Dict> findListByType(String type) {
		return dictDao.findListByType(type);
	}

}
