package com.demo.service.impl;

import com.demo.imapper.BaseMapper;
import com.demo.service.IService;
import org.springframework.beans.factory.annotation.Autowired;


public class BaseService<T,S> implements IService<T,S> {

	@Autowired
	protected BaseMapper<T,S> mapper;


	@Override
	public T selectByKey(S key) {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public int save(T model) {
		return mapper.insert(model);
	}

	@Override
	public int deleteByKey(S key) {
		return mapper.deleteByPrimaryKey(key);
	}

	@Override
	public int update(T model) {
		return mapper.update(model);
	}
}
