package com.txc.kinect.server.service.impl;

import com.txc.kinect.mvc.service.impl.BaseService;
import com.txc.kinect.server.mapper.UserAuthMapper;
import com.txc.kinect.server.model.UserAuth;
import com.txc.kinect.server.service.UserAuthService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserAuthServiceImpl extends BaseService<UserAuthMapper, UserAuth, String> implements UserAuthService {

	@Resource
	@Override
	public void setMapper(UserAuthMapper userAuthMapper) {
		this.mapper = userAuthMapper;
	}

	@Override
	public List<UserAuth> getUserAuthByUserId(Integer userId) {
		return mapper.getUserAuthByUserId(userId);
	}
}
