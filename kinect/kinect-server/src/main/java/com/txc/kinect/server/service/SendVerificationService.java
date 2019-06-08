package com.txc.kinect.server.service;

import javax.servlet.http.HttpSession;

public interface SendVerificationService {

	public boolean sendVerificationCode(String target, String content);

	boolean verify(Integer verificationCode, HttpSession httpSession);
}
