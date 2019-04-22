package com.demo.controller.model;

public class LoggedinUser {
	private Integer userId;
	private String identity;

	public LoggedinUser(){

	}

	public LoggedinUser(Integer userId, String identity){
		this.userId = userId;
		this.identity = identity;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}
}
