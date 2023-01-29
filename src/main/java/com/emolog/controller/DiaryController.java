package com.emolog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emolog.model.Diary;
import com.emolog.service.DiaryService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("diary")
public class DiaryController {

	private final DiaryService diaryService;

	@Autowired
	public DiaryController(DiaryService ds) {
		this.diaryService = ds;
	}

	@PostMapping("/")
	public ResponseEntity createDiary(@RequestBody Diary diary) {
		return diaryService.createDiary(diary);
	}

	@GetMapping("/test")
	// @ResponseBody <-- @RestController is @Controller + @ResponseBody, so this line is unnecessary
	public String testDiary(@RequestParam("name") String name) {
		return "Hi, " + name;
	}

	@GetMapping("/all")
	public ResponseEntity all(HttpServletRequest req, HttpServletResponse res) {
		String decodedAcc = (String) req.getAttribute("decodedAcc");
		return diaryService.getAllDiariesByAccToken(decodedAcc);
	}

	@GetMapping("/limit")
	public ResponseEntity limit(HttpServletRequest req, HttpServletResponse res) {
		String decodedAcc = (String) req.getAttribute("decodedAcc");
		return diaryService.getLimitedNumberDiaries(decodedAcc);
	}

}
