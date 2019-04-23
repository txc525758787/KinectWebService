package com.txc.kinect.server.mapper;

import com.txc.kinect.mvc.mapper.BaseMapper;
import com.txc.kinect.server.model.UserAuths;

public interface UserAuthsMapper extends BaseMapper<UserAuths,Integer> {

    public UserAuths selectByIdentity(String identity);

}