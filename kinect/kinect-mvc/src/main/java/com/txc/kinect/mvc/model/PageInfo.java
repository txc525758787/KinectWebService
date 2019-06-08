package com.txc.kinect.mvc.model;

import java.util.List;

public class PageInfo<T> {

	private int total;
	private List<T> rows;

	public PageInfo(){

	}

	public PageInfo(int total, List<T> rows) {
		this.total = total;
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
