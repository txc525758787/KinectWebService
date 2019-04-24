package com.txc.kinect.server.service.impl;

import com.txc.kinect.mvc.model.HttpResult;
import com.txc.kinect.mvc.model.HttpResultCode;
import com.txc.kinect.mvc.provider.MD5Provider;
import com.txc.kinect.mvc.service.impl.BaseService;
import com.txc.kinect.server.mapper.UserAuthsMapper;
import com.txc.kinect.server.model.UserAuths;
import com.txc.kinect.server.service.UserAuthsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service
@Transactional
public class UserAuthsServiceImpl extends BaseService<UserAuthsMapper,UserAuths,Integer> implements UserAuthsService {

	@Resource
	@Override
	public void setMapper(UserAuthsMapper userAuthsMapper) {
		this.mapper = userAuthsMapper;
	}

	@Override
	public UserAuths selectByIdentity(String identity) {
		return mapper.selectByIdentity(identity);
	}

	@Override
	public HttpResult login(UserAuths loginUser) {
		return HttpResult.createSuccessResult();
	}



}
