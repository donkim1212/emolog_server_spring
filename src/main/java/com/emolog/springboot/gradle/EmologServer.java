package com.emolog.springboot.gradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class EmologServer {
	DiaryController dc = new DiaryController();
	public static void main(String[] args) {
		SpringApplication.run(EmologServer.class, args);
		
		System.out.println("Hi");
	}
	
	@RequestMapping(value = "/")
	public String hello() {
		return "Hello World";
	}
	
}

