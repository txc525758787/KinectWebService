package com.demo.model;

import java.util.Date;

public class UserAuths {
	private Integer id;

	private Integer userId;

	private String identifyType;

	private String identify;

	private String credential;

	private Date lastLoginTime;

	private Date createTime;

	private Integer isEnable;

	public UserAuths(){

	}
	public UserAuths(Integer id, Integer userId, String identifyType, String identify, String credential, Date lastLoginTime, Date createTime, Integer isEnable) {
		this.id = id;
		this.userId = userId;
		this.identifyType = identifyType;
		this.identify = identify;
		this.credential = credential;
		this.lastLoginTime = lastLoginTime;
		this.createTime = createTime;
		this.isEnable = isEnable;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getIdentifyType() {
		return identifyType;
	}

	public void setIdentifyType(String identifyType) {
		this.identifyType = identifyType;
	}

	public String getIdentify() {
		return identify;
	}

	public void setIdentify(String identify) {
		this.identify = identify;
	}

	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}
}