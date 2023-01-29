package com.emolog.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//import org.springframework.data.jpa.repository.Query;

import com.emolog.model.Diary;

public interface DiaryRepository extends ModelRepository<Diary, UUID> {
//	@Query("select d from Diary d where d.author_id = ?1")
	Optional<Diary> findAllDiariesByAuthorId(UUID author_id);
//	@Query("select d from Diary d where d.author_id = ?1 limit = ?2")
	List<Diary> findLimitedDiariesByAuthorId(UUID author_id, int limit);
//	@Query("select d from Diary d where d.author_id = ?1 and d.diary_id = ?2")
	Diary findDiaryByAccAndID(String accToken, UUID id);
	
}
