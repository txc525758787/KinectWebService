package com.txc.kinect.server.service.impl;

import com.txc.kinect.mvc.service.impl.BaseService;
import com.txc.kinect.server.mapper.UserMapper;
import com.txc.kinect.server.model.User;
import com.txc.kinect.server.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
@Transactional
public class UserServiceImpl extends BaseService<UserMapper,User,Integer> implements UserService {

	@Override
	@Resource
	public void setMapper(UserMapper userMapper) {
		this.mapper = userMapper;
	}
}
