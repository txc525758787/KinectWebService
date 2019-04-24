package com.txc.kinect.server.service;

import com.txc.kinect.mvc.model.HttpResult;
import com.txc.kinect.mvc.service.IService;
import com.txc.kinect.server.model.UserAuths;



public interface UserAuthsService extends IService<UserAuths,Integer> {

	public HttpResult login(UserAuths loginUser);

	public UserAuths selectByIdentity(String identity);

}
