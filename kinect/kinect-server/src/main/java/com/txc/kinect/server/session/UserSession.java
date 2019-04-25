package com.txc.kinect.server.session;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class UserSession {
	private Integer userId;
	private String identity;

	public UserSession(){}

	public UserSession(Integer userId, String identity){
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
