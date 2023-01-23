package com.emolog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.emolog.entity.Diary;
import com.emolog.service.DiaryService;

@RestController
@RequestMapping("diary")
public class DiaryController {
	
	private final DiaryService diaryService;
	
	@Autowired
	public DiaryController (DiaryService ds) {
		this.diaryService = ds;
	}
	
//	@GetMapping ("/")
//	public ResponseEntity greetingsDiary() {
//		return ResponseEntity.ok(HttpStatus.OK);
//	}
	
	@PostMapping ("/")
	public ResponseEntity createDiary(@RequestBody Diary diary) {
		return diaryService.createDiary(diary);
	}
	
	@GetMapping ("/test")
	@ResponseBody
	public String testDiary(@RequestParam("name") String name) {
		return "Hi, " + name;
	}
	
	@GetMapping ("/all")
	public ResponseEntity defaultGetController() {
		// temp
		return ResponseEntity.ok(HttpStatus.ACCEPTED);
	}
	
	@GetMapping ("/limit")
	public void foo() {
		
	}
	
}
