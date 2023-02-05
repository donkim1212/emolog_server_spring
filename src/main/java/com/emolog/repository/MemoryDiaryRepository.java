package com.emolog.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.emolog.entity.DiaryEntity;

public class MemoryDiaryRepository implements IDiaryRepository {

	@Override
	public DiaryEntity save(DiaryEntity entity) {
		// TODO Auto-generated method stub
		System.out.println("MemoryDiaryRepository : save");
		return entity;
	}

	@Override
	public Optional<DiaryEntity> findAllDiariesByAuthorId(UUID author_id) {
		// TODO Auto-generated method stub
		List<DiaryEntity> dlist = new ArrayList<DiaryEntity>();
//		dlist.add(new Diary());
//		dlist.add(new Diary());
		return dlist.stream().findAny();

	}

	@Override
	public Optional<DiaryEntity> findById(UUID author_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<DiaryEntity> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DiaryEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<DiaryEntity> findLimitedDiariesByAuthorId(UUID author_id, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DiaryEntity findDiaryByAccAndID(String accToken, UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
