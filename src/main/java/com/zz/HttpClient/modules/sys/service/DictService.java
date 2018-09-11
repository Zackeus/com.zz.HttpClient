package com.zz.HttpClient.modules.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zz.HttpClient.common.service.CrudService;
import com.zz.HttpClient.modules.sys.dao.DictDao;
import com.zz.HttpClient.modules.sys.entity.Dict;

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

	/**
	 * 
	 * @Title：get
	 * @Description: TODO(根据ID查询字典)
	 * @see：
	 * @return
	 */
	@Cacheable(value = {"sysDictCache"}, keyGenerator = "cacheKeyGenerator")
	@Override
	public Dict get(String id) {
		return super.get(id);
	}
	
	/**
	 * 
	 * @Title：findTypeList
	 * @Description: TODO(查询字典类型列表)
	 * @see：
	 * @return
	 */
	@Cacheable(value = {"sysDictCache"}, keyGenerator = "cacheKeyGenerator")
	public List<String> findTypeList(){
		return dao.findTypeList();
	}
	
	/**
	 * 
	 * @Title：findListByType
	 * @Description: TODO(根据类型查找字典数据)
	 * @see：
	 * @param type
	 * @return
	 */
	@Cacheable(value = {"sysDictCache"}, keyGenerator = "cacheKeyGenerator")
	public List<Dict> findListByType(String type) {
		return dictDao.findListByType(type);
	}
	
	/**
	 * 
	 * @Title：save
	 * @Description: TODO(字典保存更新)
	 * @see：
	 * @return
	 */
	@CacheEvict(value = {"sysDictCache"}, allEntries = true, beforeInvocation = true)
	@Override
	public void save(Dict entity) {
		super.save(entity);
	}

}
