package com.zz.HttpClient.Bean.CTC;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @Title:Report
 * @Description:TODO(大汉三通短信推送报告)
 * @Company:
 * @author zhou.zhang
 * @date 2018年8月8日 下午3:59:07
 */
public class Report implements Serializable {

	private static final long serialVersionUID = 1L;

	private String result; 			// 结果代号
	private String desc; 			// 结果描述
	private List<DetaileReport> reports; 	// 子报告

	public Report() {
		super();
	}

	public Report(String result, String desc, List<DetaileReport> reports) {
		super();
		this.result = result;
		this.desc = desc;
		this.reports = reports;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<DetaileReport> getReports() {
		return reports;
	}

	public void setReports(List<DetaileReport> reports) {
		this.reports = reports;
	}

	@Override
	public String toString() {
		return "Report [result=" + result + ", desc=" + desc + ", reports=" + reports + "]";
	}

}
