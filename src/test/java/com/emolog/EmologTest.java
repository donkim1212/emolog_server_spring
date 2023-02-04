package com.emolog;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.emolog.model.Diary;
import com.emolog.repository.DiaryRepository;

@RunWith(SpringRunner.class)
//@ExtendWith(SpringExtension.class)
@DataJpaTest
public class EmologTest {
	
	@Autowired
	DiaryRepository dr;
	
	@Test
	public void testCreateDiary() {
		// author_id, set as random for testing
		UUID uuid = UUID.randomUUID();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		
		String title = "I'm title.";
		String emotion = "Happy";
		String content = "This is a test.";
		String pw = "1234";
		Diary d = new Diary(uuid, dtf.format(now), title, emotion, content, pw);
		
		Diary res = dr.save(d);
		
		assertEquals(d, res);
	}
	
	@Test
	public void testCreateDiaryWithNull() {
		Diary d = new Diary(null, null, null, null, null, null);
		
		Diary res = dr.save(d);
		
		assert(null == res);
	}
}
