package com.txc.kinect.mvc.service.impl;

import com.txc.kinect.mvc.mapper.BaseMapper;
import com.txc.kinect.mvc.service.IService;


public abstract class BaseService<Mapper extends BaseMapper<T,S>,T, S> implements IService<T, S> {

	protected Mapper mapper;

	/**
	 * 由子类注入相应的mapper
	 * @param mapper
	 */
	public abstract void setMapper(Mapper mapper);

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
