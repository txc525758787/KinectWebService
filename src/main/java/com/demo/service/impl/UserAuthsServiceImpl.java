package com.demo.service.impl;

import com.demo.controller.model.Result;
import com.demo.controller.model.ResultCode;
import com.demo.dao.UserAuthsMapper;
import com.demo.model.UserAuths;
import com.demo.provider.MD5Provider;
import com.demo.service.UserAuthsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserAuthsServiceImpl extends BaseService<UserAuths,Integer> implements UserAuthsService {

	@Resource
	UserAuthsMapper userAuthsMapper;

	@Override
	public Result login(UserAuths loginUser) {
		UserAuths userAuths = userAuthsMapper.selectByIdentity(loginUser.getIdentity());
		if(userAuths == null){
			return Result.createResult(ResultCode.ERROR).setMessage("此用户不存在！");
		}else if(!userAuths.getCredential().equals(MD5Provider.encrypt(loginUser.getCredential()))){
			return Result.createResult(ResultCode.ERROR).setMessage("用户名或密码错误！");
		}else if(userAuths.getIsEnable()==0){
			return Result.createResult(ResultCode.ERROR).setMessage("此用户已被禁用");
		}
		return Result.createSuccessResult();
	}
}
