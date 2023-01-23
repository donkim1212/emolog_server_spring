package com.emolog.repository;

import java.io.Serializable;

public interface ModelRepository<T, ID extends Serializable> {
	T findOne(ID id);
	T save(T entity);
}