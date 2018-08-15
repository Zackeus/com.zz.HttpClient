package com.zz.HttpClient.Service.sys;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zz.HttpClient.Bean.Sys.Role;
import com.zz.HttpClient.Dao.sys.RoleDao;
import com.zz.HttpClient.Service.Basic.CrudService;
import com.zz.HttpClient.Util.Logs;

/**
 * 
 * @Title:RoleService
 * @Description:TODO(角色Service)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年8月15日 下午1:10:15
 */
@Service("roleService")
public class RoleService extends CrudService<RoleDao, Role> {

	@Autowired
	RoleDao roleDao;
	
	@Cacheable(value = {"authorizationCache"})
	public List<Role> findAllList(Role role) {
		return roleDao.findAllList(role);
	}
	
	@Cacheable(value = {"authorizationCache"})
	public List<Role> getRoleByUser(Role role) {
		return roleDao.getRoleByUser(role);
	}
	
	@CacheEvict(value = {"authorizationCache"},allEntries = true)
	public void clearCache() {
		Logs.info("清除用户缓存.......");
	}

}
