package com.txc.kinect.server.service;

import com.txc.kinect.mvc.model.Result;
import com.txc.kinect.mvc.service.IService;
import com.txc.kinect.server.model.UserAuths;



public interface UserAuthsService extends IService<UserAuths,Integer> {

	public Result login(UserAuths loginUser);

}
