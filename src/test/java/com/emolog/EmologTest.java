package com.emolog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.emolog.model.Diary;
import com.emolog.repository.DiaryRepository;

@RunWith(SpringRunner.class)
//@ExtendWith(SpringExtension.class)
//@DataJpaTest
@SpringBootTest
public class EmologTest {
	
	@Autowired
	DiaryRepository dr;
	
	UUID uuid = UUID.randomUUID();
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	
	String title = "I'm title.";
	String emotion = "Happy";
	String content = "This is a test.";
	String pw = "1234";
	
	@Test
	public void testCreateDiary() {
		// author_id, set as random for testing
		
		Diary d = new Diary(uuid, dtf.format(now), title, emotion, content, pw);
		
		Diary res = null;
		
		try {
			res = dr.save(d);
		} catch (Exception e) {
			
		}
		
		assertEquals(d, res);
	}
	
	@Test
	public void testCreateDiaryWithNull() {
		Diary d = new Diary(null, null, null, null, null, null);
		Diary res = null;
		
		try {
			res = dr.save(d);
		} catch (Exception e) {
			// Even with save() handling exceptions from em.persist(), it needs
			// catching exceptions outside save(), because of how @Transactional works.
			// Simply put, exceptions caused by @Transactional happens outside of the method's try/catch,
			// making JUnit test always throw exception. May also happen with services, so keep this in mind.
			// Leaving this area empty would suffice.
		}
		
		assert(null == res);
	}
	
	@Test
	public void testFindAllDiaries() {
//		Diary d = new Diary(uuid, dtf.format(now), title, emotion, content, pw);
//		dr.save(d);
		
		List<Diary> diaries = dr.findAll();
		
		assertFalse(diaries.isEmpty());
	}
}
