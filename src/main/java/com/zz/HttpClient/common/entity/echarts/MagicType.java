package com.zz.HttpClient.common.entity.echarts;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 
 * @Title:MagicType
 * @Description:TODO(动态类型切换)
 * @Company:
 * @author zhou.zhang
 * @date 2018年9月11日 上午9:14:24
 */
public class MagicType implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> type = Arrays.asList("line", "bar", "stack", "tiled");

	public MagicType() {
		super();
	}

	public MagicType(List<String> type) {
		super();
		this.type = type;
	}

	public List<String> getType() {
		return type;
	}

	public void setType(List<String> type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
