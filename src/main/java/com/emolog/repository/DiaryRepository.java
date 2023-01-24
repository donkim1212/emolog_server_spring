package com.emolog.repository;

import java.util.UUID;

import com.emolog.model.Diary;

public interface DiaryRepository extends ModelRepository<Diary, UUID> {
	Diary findAllDiariesByAccToken(String accToken);
//	Diary findDiaryByAccAndID(String accToken, UUID id);
}
