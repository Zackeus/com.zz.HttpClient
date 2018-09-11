package com.zz.HttpClient.modules.sys.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.zz.HttpClient.common.entity.DataEntity;

/**
 * 
 * @Title:Dict
 * @Description:TODO(字典Entity)
 * @Company:
 * @author zhou.zhang
 * @date 2018年8月22日 下午2:57:32
 */
public class Dict extends DataEntity<Dict> {

	private static final long serialVersionUID = 1L;

	@NotBlank(message = "{dict.value.NotBlank}")
	private String value;			// 数据值
	
	@NotBlank(message = "{dict.label.NotBlank}")
	private String label;			// 标签名
	
	@NotBlank(message = "{dict.type.NotBlank}")
	private String type;			// 类型
	
	private String description;		// 描述
	
	@NotNull(message = "{dict.sort.NotNull}")
	private Integer sort = 10;			// 排序

	public Dict() {
		super();
	}

	public Dict(String id) {
		super(id);
	}

	public Dict(String label, String type, String description, Integer sort) {
		super();
		this.label = label;
		this.type = type;
		this.description = description;
		this.sort = sort;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
}
