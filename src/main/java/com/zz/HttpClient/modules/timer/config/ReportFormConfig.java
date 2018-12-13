package com.zz.HttpClient.modules.timer.config;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @Title:ReportFormConfig
 * @Description:TODO(报表配置类)
 * @Company: 
 * @author zhou.zhang
 * @date 2018年12月12日 下午2:39:55
 */
@Component
public class ReportFormConfig {
	
	@Value("${reportFormConfig.filePath}")
	private String filePath;	// 报表目录
	@Value("${reportFormConfig.smbPath}")
	private String smbPath;		// 远程报表目录
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getSmbPath() {
		return smbPath;
	}

	public void setSmbPath(String smbPath) {
		this.smbPath = smbPath;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
