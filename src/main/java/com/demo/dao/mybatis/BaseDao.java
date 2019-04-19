package com.demo.dao.mybatis;

import java.io.Serializable;

public interface BaseDao<T,ID extends Serializable>{

	public int deleteByPrimaryKey(ID pk);

	public int insert(T t);

	public int insertSelective(T t);

	public T selectByPrimaryKey(ID pk);

	public int updateByPrimaryKeySelective(T t);

	public int updateByPrimaryKey(T t);
}
