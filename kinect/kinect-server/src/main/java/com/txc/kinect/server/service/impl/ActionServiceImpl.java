package com.txc.kinect.server.service.impl;

import com.txc.kinect.mvc.service.impl.BaseService;
import com.txc.kinect.server.mapper.ActionMapper;
import com.txc.kinect.server.model.Action;
import com.txc.kinect.server.service.ActionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class ActionServiceImpl extends BaseService<ActionMapper,Action,Integer> implements ActionService {

	@Override
	@Resource
	public void setMapper(ActionMapper actionMapper) {
		this.mapper = actionMapper;
	}
}
