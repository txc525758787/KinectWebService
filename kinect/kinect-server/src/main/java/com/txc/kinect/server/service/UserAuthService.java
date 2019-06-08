package com.txc.kinect.server.service;

import com.txc.kinect.mvc.service.IService;
import com.txc.kinect.server.model.UserAuth;

import java.util.List;


public interface UserAuthService extends IService<UserAuth, String> {

	public List<UserAuth> getUserAuthByUserId(Integer userId);

}
