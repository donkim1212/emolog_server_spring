package com.emolog.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.emolog.entity.Diary;

@Repository
public interface DiaryRepository extends ModelRepository<Diary, UUID> {
	Diary findAllDiariesByAccToken(String accToken);
//	Diary findDiaryByAccAndID(String accToken, UUID id);
}
