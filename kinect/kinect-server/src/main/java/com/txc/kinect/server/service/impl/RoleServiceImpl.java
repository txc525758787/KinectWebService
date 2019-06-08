package com.txc.kinect.server.service.impl;

import com.txc.kinect.mvc.service.impl.BaseService;
import com.txc.kinect.server.mapper.RoleMapper;
import com.txc.kinect.server.model.Role;
import com.txc.kinect.server.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class RoleServiceImpl extends BaseService<RoleMapper, Role, Integer> implements RoleService {

	@Override
	@Resource
	public void setMapper(RoleMapper roleMapper) {
		this.mapper = roleMapper;
	}
}
