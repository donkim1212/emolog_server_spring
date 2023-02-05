package com.emolog.repository;

import java.util.Optional;
import java.util.UUID;

import com.emolog.entity.DiaryEntity;

public interface IDiaryRepository extends IModelRepository<DiaryEntity, UUID> {
//	@Query("select d from Diary d where d.author_id = ?1")
	Optional<DiaryEntity> findAllDiariesByAuthorId(UUID author_id);
//	@Query("select d from Diary d where d.author_id = ?1 limit = ?2")
	Optional<DiaryEntity> findLimitedDiariesByAuthorId(UUID author_id, int limit);
//	@Query("select d from Diary d where d.author_id = ?1 and d.diary_id = ?2")
	DiaryEntity findDiaryByAccAndID(String accToken, UUID id);
	
}
