package com.emolog.repository;

import java.util.List;
import java.util.Optional;

public interface ModelRepository<T, ID> {
	T save (T entity);
	Optional<T> findById(ID id);
	Optional<T> findByName(String name);
	List<T> findAll();
}