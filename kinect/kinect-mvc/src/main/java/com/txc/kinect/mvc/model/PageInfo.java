package com.txc.kinect.mvc.model;

import java.util.List;

public class PageInfo<T> {

	private int dataLength;
	private List<T> list;

	public PageInfo(){

	}

	public PageInfo(int dataLength, List<T> list) {
		this.dataLength = dataLength;
		this.list = list;
	}

	public int getDataLength() {
		return dataLength;
	}

	public void setDataLength(int dataLength) {
		this.dataLength = dataLength;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
