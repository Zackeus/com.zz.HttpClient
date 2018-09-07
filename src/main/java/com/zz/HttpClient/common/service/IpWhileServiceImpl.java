package com.zz.HttpClient.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz.HttpClient.common.dao.IpWhileDao;

@Service("ipWhileService")
public class IpWhileServiceImpl implements IpWhileService {
	
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
