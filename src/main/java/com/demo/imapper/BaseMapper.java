package com.demo.imapper;


import java.io.Serializable;

public interface BaseMapper<T,ID extends Serializable>{

	public int deleteByPrimaryKey(ID pk);

	public int insert(T t);

	public int insertSelective(T t);

	public T selectByPrimaryKey(ID pk);

	public int updateSelective(T t);

	public int update(T t);
}
