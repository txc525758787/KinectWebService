package com.txc.kinect.server.service.impl;

import com.txc.kinect.server.service.PhoneService;
import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl implements PhoneService {
	@Override
	public boolean sendVerificationCode(String target, String content) {
		return false;
	}
}
