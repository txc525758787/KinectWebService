package com.demo.service.impl;

import com.demo.imapper.BaseMapper;
import com.demo.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;


public class BaseService<T,S extends Serializable> implements IService<T,S> {

	@Autowired
	protected BaseMapper<T,S> mapper;


	@Override
	public T selectByKey(S key) {
		return mapper.selectByPrimaryKey(key);
	}

	@Override
	public int save(T model) {
		return 0;
	}

	@Override
	public int deleteByKey(S key) {
		return 0;
	}

	@Override
	public int update(T model) {
		return 0;
	}
}
