package com.emolog.springboot.gradle;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;


//@EnableAutoConfiguration
//@EnableJpaRepositories
@SpringBootApplication
@EnableConfigurationProperties(DiaryConfigProperties.class)
@ComponentScan(basePackages = { "com.emolog.service","com.emolog.controller", "com.emolog.entity"} )
public class EmologServer {
//	private DiaryController dc = new DiaryController(new DiaryService());
	public static void main(String[] args) {
		SpringApplication.run(EmologServer.class, args);
		
		System.out.println("Hi");
	}
	
}

