package com.emolog.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.emolog.model.Diary;

public class MemoryDiaryRepository implements DiaryRepository {

	@Override
	public Diary save(Diary entity) {
		// TODO Auto-generated method stub
		System.out.println("MemoryDiaryRepository : save");
		return entity;
	}

	@Override
	public Optional<Diary> findAllDiariesByAuthorId(UUID author_id) {
		// TODO Auto-generated method stub
		List<Diary> dlist = new ArrayList<Diary>();
//		dlist.add(new Diary());
//		dlist.add(new Diary());
		return dlist.stream().findAny();

	}

	@Override
	public Optional<Diary> findById(UUID author_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Diary> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Diary> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Diary> findLimitedDiariesByAuthorId(UUID author_id, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Diary findDiaryByAccAndID(String accToken, UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
