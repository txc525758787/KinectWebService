package com.txc.kinect.server.service;

import com.txc.kinect.mvc.service.IService;
import com.txc.kinect.server.model.UserRecord;

import java.util.List;

public interface UserRecordService extends IService<UserRecord,Integer> {

	public List<UserRecord> findRecordsByUserId(Integer userId);

}
