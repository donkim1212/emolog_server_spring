package com.emolog.configuration;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.emolog.model.Diary;
import com.emolog.repository.DiaryRepository;
import com.emolog.repository.MemoryDiaryRepository;
import com.emolog.service.DiaryService;

@Configuration
@ConfigurationProperties(prefix="diary")
@EnableJpaRepositories(basePackageClasses = Diary.class)
public class DiaryConfig {
//	@Bean
//	public DiaryService diaryService() {
//		return new DiaryService(diaryRepository());
//	}
//	
//	@Bean
//	public DiaryRepository diaryRepository() {
//		return new MemoryDiaryRepository();
//	}
//	
//	@Bean
//	public Diary diary() {
//		return new Diary();
//	}
}
