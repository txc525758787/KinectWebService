package com.txc.kinect.server.service.impl;

import com.txc.kinect.mvc.service.impl.BaseService;
import com.txc.kinect.server.mapper.UserRecordMapper;
import com.txc.kinect.server.model.UserRecord;
import com.txc.kinect.server.service.UserRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserRecordServiceImpl extends BaseService<UserRecordMapper,UserRecord,Integer> implements UserRecordService {

	@Override
	@Resource
	public void setMapper(UserRecordMapper userRecordMapper) {
		this.mapper = userRecordMapper;
	}

	@Override
	public List<UserRecord> findRecordsByUserId(Integer userId) {
		return mapper.findRecordsByUserId(userId);
	}
}
