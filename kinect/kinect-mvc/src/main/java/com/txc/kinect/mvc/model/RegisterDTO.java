package com.txc.kinect.mvc.model;

public class RegisterDTO {
	private String identityType;
	private String identity;
	private String credential;
	private Integer verification;//6位验证码

	public RegisterDTO(){

	}
	public RegisterDTO(String identityType, String identity, String credential, Integer verification) {
		this.identityType = identityType;
		this.identity = identity;
		this.credential = credential;
		this.verification = verification;
	}

	public String getIdentityType() {
		return identityType;
	}

	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}

	public Integer getVerification() {
		return verification;
	}

	public void setVerification(Integer verification) {
		this.verification = verification;
	}
}
