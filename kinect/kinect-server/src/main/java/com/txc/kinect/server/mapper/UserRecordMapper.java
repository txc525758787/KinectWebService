package com.txc.kinect.server.mapper;

import com.txc.kinect.mvc.mapper.BaseMapper;
import com.txc.kinect.server.model.UserRecord;

import java.util.List;

public interface UserRecordMapper extends BaseMapper<UserRecord,Integer> {

	public List<UserRecord> findRecordsByUserId(Integer userId);

}