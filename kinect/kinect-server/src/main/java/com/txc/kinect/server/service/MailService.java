package com.txc.kinect.server.service;

public interface MailService {
	public boolean sendVerificationCode(String target, String content);
}
