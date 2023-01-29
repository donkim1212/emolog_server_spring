package com.emolog;

//import org.junit.Test;
import org.junit.jupiter.api.Test;

import com.emolog.repository.MemoryDiaryRepository;
import com.emolog.service.DiaryService;

import jakarta.servlet.http.HttpServletRequest;

public class EmologTest {
//	HttpServletRequest req;
	DiaryService ds = new DiaryService(new MemoryDiaryRepository());
	@Test
	public void testCreateDiary() {
//		ds.createDiary()
	}
}
