package com.zz.HttpClient.Bean.Sys.timer.collectionRobot;

import com.zz.HttpClient.Bean.Basic.DataEntity;

/**
 * 
 * @Title:OverdueCustomer
 * @Description:TODO(客户类型实体)
 * @Company:
 * @author zhou.zhang
 * @date 2018年8月21日 上午11:49:03
 */
public class CustomerStyle extends DataEntity<CustomerStyle> {

	private static final long serialVersionUID = 1L;
	private String name; // 逾期客户类型名

	public CustomerStyle() {
		super();
	}

	public CustomerStyle(String id) {
		super(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
