package com.emolog.springboot.gradle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emolog.model.Diary;

@RestController
public class DiaryController {
	@PostMapping ("/diary")
	public ResponseEntity createDiary(@RequestBody Diary diary) {
		// temp
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@GetMapping ("/diary/all")
	public ResponseEntity defaultGetController() {
		// temp
		return ResponseEntity.ok(HttpStatus.ACCEPTED);
	}
	
	@GetMapping ("/diary/limit")
	public void foo() {
		
	}
}
