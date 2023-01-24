package com.emolog.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.emolog.model.Diary;

@Repository
public class MemoryDiaryRepository implements DiaryRepository{

	@Override
	public Diary save(Diary entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Diary findAllDiariesByAccToken(String accToken) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Diary> findById(UUID id) {
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
	
}
