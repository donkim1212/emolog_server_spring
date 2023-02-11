package com.emolog;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.emolog.entity.DiaryEntity;
import com.emolog.repository.IDiaryJpaRepository;
import com.emolog.repository.IDiaryRepository;
import com.emolog.repository.IUserRepository;

@RunWith(SpringRunner.class)
//@ExtendWith(SpringExtension.class)
//@DataJpaTest // won't add anything to db
@SpringBootTest // will actually add to db
@TestMethodOrder(OrderAnnotation.class)
public class EmologRepositoryTest {
	
	@Autowired
	IDiaryRepository dr;
	
	@Autowired
	IDiaryJpaRepository djr;
	
	@Autowired
	IUserRepository ur;
	
	UUID uuid = UUID.randomUUID();
	
//	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//	LocalDateTime now = LocalDateTime.now();
//	dtf.format(now);
	String now = OffsetDateTime.now().format(DateTimeFormatter.ofPattern("yy-MM-dd"));
	
	String title = "I'm title.";
	String emotion = "Happy";
	String content = "This is a test.";
	String pw = "1234";
	
	DiaryEntity temp;
	
	@Test
	@Order(1)
	public void testJpaRepositoryCreateDiaryReturnsDiaryId() {
		DiaryEntity d = new DiaryEntity(uuid, now, "JpaRepository", emotion, content, pw);
		
		DiaryEntity res = null;
		
		try {
			res = djr.save(d);
		} catch (Exception e) {
			
		}
		
//		assertEquals(d, res);
		assertFalse(res.getDiaryId() == null);
	}
	
	@Test
	@Order(2)
	public void testCustomRepositoryCreateDiaryReturnsDiaryId() {
		// author_id, set as random for testing
		
		DiaryEntity d = new DiaryEntity(uuid, now, "CustomRepository", emotion, content, pw);
		
		DiaryEntity res = null;
		
		try {
			res = dr.save(d);
		} catch (Exception e) {
			
		}
		
//		assertEquals(d, res);
		assertFalse(res.getDiaryId() == null);
		temp = res;
	}
	
	@Test
	@Order(3)
	public void testCreateDiaryReturnsCreatedAt() {
		// author_id, set as random for testing
		DiaryEntity d = new DiaryEntity(uuid, now, title, emotion, content, pw, null, null);
		
		DiaryEntity res = null;
		
		try {
			res = djr.save(d);
			UUID id = res.getDiaryId();
			res = djr.findById(id).get();
		} catch (Exception e) {
			
		}
		
		assertFalse(res.getCreatedAt() == null);
	}
	
	/*
	@Test
	public void testCreateDiaryWithNull() {
		DiaryEntity d = new DiaryEntity(null, null, null, null, null, null, null, null);
		DiaryEntity res = null;
		
		try {
			res = dr.save(d);
		} catch (Exception e) {
			// Even with save() handling exceptions from em.persist(), it needs
			// catching exceptions outside save(), because of how @Transactional works.
			// Simply put, exceptions caused by @Transactional happens outside of the method's try/catch,
			// making JUnit test always throw exception. May also happen with services, so keep this in mind.
			// Leaving this area empty would suffice.
		}
		
		assertNull(res);
	}
	*/
	
	@Test
	@Order(4)
	public void testFindAllDiaries() {
//		Diary d = new Diary(uuid, dtf.format(now), title, emotion, content, pw);
//		dr.save(d);
		
		List<DiaryEntity> diaries = dr.findAll();
		
		assertFalse(diaries.isEmpty());
	}
}
