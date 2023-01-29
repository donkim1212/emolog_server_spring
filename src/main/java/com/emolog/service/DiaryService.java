package com.emolog.service;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public ResponseEntity createDiary(Diary reqData) {
		if (diaryRepository.save(reqData) == null) {
			// if not successful,
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		} else {
			// if successful,
			System.out.println("Added to DB.");
			JSONObject resData = new JSONObject();
			resData.put("message", "Diary Created");
			resData.put("diary_id", reqData.getDiaryId());
			resData.put("diary_emotion", reqData.getDiaryEmotion());
			resData.put("calendar_date", reqData.getCalendarDate());
			return new ResponseEntity(resData, HttpStatus.CREATED);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity getAllDiariesByAccToken (String token) {
		
		JSONObject resData = new JSONObject();
		resData.put("message", "Got all Diaries");
		// resData.put("data", dList);

		return new ResponseEntity(resData, HttpStatus.OK);
	}
	
	public ResponseEntity getLimitedNumberDiaries (String decodedAcc) {
		
		return ResponseEntity.ok(HttpStatus.OK);
	}
}
