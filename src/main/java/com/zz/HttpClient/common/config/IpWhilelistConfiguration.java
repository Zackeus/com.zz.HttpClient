package com.zz.HttpClient.common.config;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zz.HttpClient.common.service.IpWhileService;


/**
 * 
 * @Title:IpWhilelistConfiguration
 * @Description:TODO(IP白名单列表)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年7月9日 下午3:50:06
 */
@Configuration
public class IpWhilelistConfiguration {
	
	@Resource
	private IpWhileService ipWhileService;
	
	/**
	 * 
	 * @Title:ipWhileListByYQX
	 * @Description: TODO(接收云企讯短信状态推送IP白名单)
	 * @return
	 */
	@Bean(name="ipWhileListByYQX")
	public List<String> ipWhileListByYQX() {
		return ipWhileService.getIpWhileLists("CO-094404");
	}
	
	/**
	 * 
	 * @Title:ipWhileListByJuHe
	 * @Description: TODO(接收据合速驰催收机器人拨打结果推送IP白名单)
	 * @return
	 */
	@Bean(name="ipWhileListByJuHe")
	public List<String> ipWhileListByJuHe() {
		return ipWhileService.getIpWhileLists("CO-344552");
	}
	
	/**
	 * 
	 * @Title:ipWhileListByJuHe
	 * @Description: TODO(大汉三通短信结果推送IP白名单)
	 * @return
	 */
	@Bean(name="ipWhileListByDaHan")
	public List<String> ipWhileListByDaHan() {
		return ipWhileService.getIpWhileLists("CO-344477");
	}
}
