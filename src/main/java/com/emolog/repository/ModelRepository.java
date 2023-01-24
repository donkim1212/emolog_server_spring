package com.emolog.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface ModelRepository<T, ID extends Serializable> {
	Optional<T> findById(ID id);
	Optional<T> findByName(String name);
	List<T> findAll();
	T save(T entity);
}