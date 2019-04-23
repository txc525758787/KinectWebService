package com.txc.kinect.mvc.service;


public interface IService<T,S> {

	/**
	 *
	 */
	T selectByKey(S key);

	/**
	 *
	 */
	int save(T model);

	/**
	 *
	 */
	int deleteByKey(S key);

	/**
	 *
	 */
	int update(T model);

}
