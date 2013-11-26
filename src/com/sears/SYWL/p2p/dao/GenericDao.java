package com.sears.SYWL.p2p.dao;


public interface GenericDao<T>{
	void merge(T entity);
	void delete(T obj);
	void save (T t);

}