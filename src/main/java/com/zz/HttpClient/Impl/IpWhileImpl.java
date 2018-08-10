package com.zz.HttpClient.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz.HttpClient.Dao.IpWhileDao;
import com.zz.HttpClient.Service.IpWhileService;

@Service("ipWhileService")
public class IpWhileImpl implements IpWhileService {
	
	@Autowired
	private IpWhileDao IpWhileListDao;

	/**
	 * 查询云企讯接口白名单
	 */
	@Override
	public List<String> getIpWhileLists(String coId) {
		return IpWhileListDao.getIpWhileLists(coId);
	}
}
