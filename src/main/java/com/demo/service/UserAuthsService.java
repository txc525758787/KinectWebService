package com.demo.service;

import com.demo.controller.model.Result;
import com.demo.model.UserAuths;

public interface UserAuthsService extends IService<UserAuths,Integer> {

	public Result login(UserAuths loginUser);

}
