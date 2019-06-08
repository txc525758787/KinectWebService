package com.txc.kinect.server.service.impl;

import com.txc.kinect.server.service.MailService;
import com.txc.kinect.server.service.PhoneService;
import com.txc.kinect.server.service.SendVerificationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Service
public class SendVerificationServiceImpl implements SendVerificationService {

	@Resource
	PhoneService phoneService;
	@Resource
	MailService mailService;

	@Override
	public boolean sendVerificationCode(String target, String content) {
		return false;
	}

	@Override
	public boolean verify(Integer verificationCode, HttpSession httpSession) {
		if (!verificationCode.equals(httpSession.getAttribute("verification"))) {
			return false;
		}
		return true;
	}
}
