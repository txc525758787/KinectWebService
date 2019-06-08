package com.txc.kinect.server.service;

import com.txc.kinect.mvc.service.IService;
import com.txc.kinect.server.model.User;

import java.util.List;

public interface UserService extends IService<User, Integer> {
	/**
	 * 创建默认user（id自增,nickname=“用户”+identity,avatar=default,userRole默认1)
	 *
	 * @param identity
	 * @retur userId
	 */
	public User createDefaultUser(String identity);

	public List<User> getAllUser();
}
