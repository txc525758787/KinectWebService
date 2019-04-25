package com.txc.kinect.mvc.service.impl;

import com.txc.kinect.mvc.exception.MapperException;
import com.txc.kinect.mvc.mapper.BaseMapper;
import com.txc.kinect.mvc.service.IService;


public abstract class BaseService<Mapper extends BaseMapper<T, S>, T, S> implements IService<T, S> {

	protected Mapper mapper;

	/**
	 * 由子类注入相应的mapper
	 *
	 * @param mapper
	 */
	public abstract void setMapper(Mapper mapper);

	public T selectByKey(S key) {
		try {
			return mapper.selectByPrimaryKey(key);
		} catch (Exception e) {
			throw new MapperException();
		}
	}


	public int insert(T model) {
		try {
			return mapper.insert(model);
		} catch (Exception e) {
			throw new MapperException();
		}
	}


	public int deleteByKey(S key) {
		try {
			return mapper.deleteByPrimaryKey(key);
		} catch (Exception e) {
			throw new MapperException();
		}
	}


	public int update(T model) {
		try {
			return mapper.update(model);
		} catch (Exception e) {
			throw new MapperException();
		}
	}
}
