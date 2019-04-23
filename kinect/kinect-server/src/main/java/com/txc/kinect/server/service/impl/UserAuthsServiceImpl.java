package com.txc.kinect.server.service.impl;

import com.txc.kinect.mvc.model.Result;
import com.txc.kinect.mvc.model.ResultCode;
import com.txc.kinect.mvc.provider.MD5Provider;
import com.txc.kinect.server.mapper.UserAuthsMapper;
import com.txc.kinect.server.model.UserAuths;
import com.txc.kinect.server.service.BaseService;
import com.txc.kinect.server.service.UserAuthsService;
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
