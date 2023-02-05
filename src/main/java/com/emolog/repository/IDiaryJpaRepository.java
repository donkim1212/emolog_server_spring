package com.emolog.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emolog.entity.DiaryEntity;

//@Repository // JpaRepositories won't need this
public interface IDiaryJpaRepository extends JpaRepository<DiaryEntity, UUID> {
	
}
