package com.emolog.springboot.gradle;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.emolog.entity.Diary;
import com.emolog.repository.DiaryRepository;
import com.emolog.repository.MemoryDiaryRepository;
import com.emolog.service.DiaryService;

@Configuration
@ConfigurationProperties(prefix="diary")
public class DiaryConfigProperties {
	@Bean
	public DiaryService diaryService() {
		return new DiaryService(diaryRepository());
	}
	
	@Bean
	public DiaryRepository diaryRepository() {
		return new MemoryDiaryRepository();
	}
	
	@Bean
	public Diary diary() {
		return new Diary();
	}
}
