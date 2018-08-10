package com.zz.HttpClient.Bean;

import java.io.Serializable;
import java.util.List;

public class Result implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> rows;

	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Result(List<String> rows) {
		super();
		this.rows = rows;
	}

	public List<String> getRows() {
		return rows;
	}

	public void setRows(List<String> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "Result [rows=" + rows + "]";
	}

}
