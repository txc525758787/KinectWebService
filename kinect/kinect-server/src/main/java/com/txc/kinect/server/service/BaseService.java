package com.txc.kinect.server.service;

import com.txc.kinect.mvc.mapper.BaseMapper;
import com.txc.kinect.mvc.service.IService;
import org.springframework.beans.factory.annotation.Autowired;


public  class BaseService<T, S> implements IService<T, S> {

	@Autowired
	protected BaseMapper<T,S> mapper;

	public T selectByKey(S key) {
		return mapper.selectByPrimaryKey(key);
	}


	public int save(T model) {
		return mapper.insert(model);
	}


	public int deleteByKey(S key) {
		return mapper.deleteByPrimaryKey(key);
	}


	public int update(T model) {
		return mapper.update(model);
	}
}
