package com.emolog.configuration;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.emolog.entity.DiaryEntity;
import com.emolog.repository.IDiaryRepository;
import com.emolog.repository.CustomDiaryRepository;

import jakarta.persistence.EntityManager;

@Configuration
@EnableJpaRepositories(basePackages = "com.emolog.repository")
public class JpaConfig {
//	@Bean
//	public DiaryService diaryService() {
//		return new DiaryService(diaryRepository());
//	}
//	
//	@Bean
//	public DiaryRepository diaryRepository() {
//		return new CustomDiaryRepository();
//	}
}
