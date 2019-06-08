package com.txc.kinect.server.service.impl;

import com.txc.kinect.server.service.MailService;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
	@Override
	public boolean sendVerificationCode(String target, String content) {
		return true;
	}
}
