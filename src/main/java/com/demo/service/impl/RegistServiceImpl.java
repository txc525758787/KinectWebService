package com.demo.service.impl;

import com.demo.model.User;
import com.demo.model.UserAuths;
import com.demo.provider.MD5Provider;
import com.demo.service.RegistService;
import com.demo.service.UserAuthsService;
import com.demo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Service
public class RegistServiceImpl implements RegistService {

	@Resource
	UserService userService;
	@Resource
	UserAuthsService userAuthsService;

	@Override
	@Transactional
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
