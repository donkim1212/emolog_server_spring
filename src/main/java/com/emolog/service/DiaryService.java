package com.emolog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.emolog.model.Diary;
import com.emolog.repository.DiaryRepository;

@Service
public class DiaryService {
	
	private final DiaryRepository diaryRepository;
	
	@Autowired
	public DiaryService (DiaryRepository dr) {
		this.diaryRepository = dr;
//		System.out.println("DS");
	}
	
	public ResponseEntity createDiary(Diary reqData) {
		// TODO: DB interaction
		System.out.println("Added to DB.");
		return ResponseEntity.ok(HttpStatus.OK);
	}
}