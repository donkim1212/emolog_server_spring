package com.emolog.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.emolog.entity.DiaryEntity;
import com.emolog.repository.IDiaryRepository;

@Service
//@Transactional
public class DiaryService {
	
	private final IDiaryRepository diaryRepository;
	
	@Autowired
	public DiaryService (IDiaryRepository dr) {
		this.diaryRepository = dr;
//		System.out.println("DS");
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity createDiary(DiaryEntity reqData) {
		// TODO try-catch the repo.save()
		if (diaryRepository.save(reqData) == null) {
			// if not successful,
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		} else {
			// if successful,
			System.out.println("Added to DB.");
			JSONObject resData = new JSONObject();
			resData.put("message", "Diary Created");
//			resData.put("diary_id", reqData.getDiaryId());
//			resData.put("diary_emotion", reqData.getDiaryEmotion());
//			resData.put("calendar_date", reqData.getCalendarDate());
			return new ResponseEntity<JSONObject>(resData, HttpStatus.CREATED);
		}
	}
	
	/**
	 * 
	 * @param decodedToken author_id from HTTP request decoded by diaryService
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseEntity getAllDiariesByAccToken (String decodedToken) {
		Optional<DiaryEntity> diaries = diaryRepository.findAllDiariesByAuthorId(UUID.fromString(decodedToken));
		
		JSONObject resData = new JSONObject();
		resData.put("message", "Got all Diaries");
		resData.put("data", diaries);

		return new ResponseEntity(resData, HttpStatus.OK);
	}
	
	@SuppressWarnings("rawtypes")
	public ResponseEntity getLimitedNumberDiaries (String decodedAcc) {
		
		return ResponseEntity.ok(HttpStatus.OK);
	}
}
