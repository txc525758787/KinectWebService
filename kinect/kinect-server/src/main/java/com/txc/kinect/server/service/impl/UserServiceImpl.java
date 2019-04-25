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

	@Override
	public User createDefaultUser(String identity) {
		User user = new User();
		user.setNickname("用户"+identity);
		user.setRoleId(1);
		user.setAvatar("/avatar/default.jpg");
		user.setRoleId(1);
		this.insert(user);
		return user;
	}
}
