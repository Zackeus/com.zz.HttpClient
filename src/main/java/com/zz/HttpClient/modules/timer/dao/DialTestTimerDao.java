package com.zz.HttpClient.modules.timer.dao;

import org.apache.ibatis.annotations.Param;

import com.zz.HttpClient.common.annotation.MyBatisDao;
import com.zz.HttpClient.common.dao.CrudDao;
import com.zz.HttpClient.modules.timer.entity.DialTestTimer;


/**
 * 
 * @Title:DialTestTimerDao
 * @Description:TODO(拨号测试DAO接口)
 * @Company: 
 * @author zhou.zhang
 * @date 2019年1月14日 上午9:00:43
 */
@MyBatisDao
public interface DialTestTimerDao extends CrudDao<DialTestTimer> {
	
	public int updateStatusByJobName(@Param("dialTestTimer") DialTestTimer dialTestTimer, @Param("status") boolean status);

}
