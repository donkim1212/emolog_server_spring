package com.emolog.configuration;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.emolog.model.Diary;
import com.emolog.repository.DiaryRepository;
import com.emolog.repository.JpaDiaryRepository;

import jakarta.persistence.EntityManager;

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
//		return new JpaDiaryRepository();
//	}
//	
//	@Bean
//	public Diary diary() {
//		return new Diary();
//	}
}
