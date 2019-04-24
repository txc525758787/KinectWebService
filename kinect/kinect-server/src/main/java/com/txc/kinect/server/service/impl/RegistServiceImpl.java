package com.txc.kinect.server.service.impl;

import com.txc.kinect.mvc.provider.MD5Provider;
import com.txc.kinect.server.model.User;
import com.txc.kinect.server.model.UserAuths;
import com.txc.kinect.server.service.RegistService;
import com.txc.kinect.server.service.UserAuthsService;
import com.txc.kinect.server.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service
@Transactional
public class RegistServiceImpl implements RegistService {

	@Resource
	UserService userService;
	@Resource
	UserAuthsService userAuthsService;

	@Override
	public void regist(UserAuths register) {

		User user = new User();
		//process user
		user.setAvatar("/avatar/default.jpg");
		user.setNickname("用户"+register.getIdentity());
		user.setRoleId(1);
		userService.save(user);
		//process userAuths
		register.setUserId(user.getId()); //insertUser后自增id会回写给user.id
		register.setCredential(MD5Provider.encrypt(register.getCredential()));
		register.setIsEnable(1);
		register.setCreateTime(new Date());
		userAuthsService.save(register);
	}
}
