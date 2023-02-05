package com.emolog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableAutoConfiguration
//@ConfigurationPropertiesScan("com.emolog.configuration")
//@EnableAutoConfiguration(exclude = { // remove later on
//	    DataSourceAutoConfiguration.class,
//	    DataSourceTransactionManagerAutoConfiguration.class,
//	    HibernateJpaAutoConfiguration.class})
@EnableJpaRepositories
@ComponentScan("com.emolog.*")
@EntityScan("com.emolog.model")
public class EmologServer {
//	private DiaryController dc = new DiaryController(new DiaryService());
	public static void main(String[] args) {
		SpringApplication.run(EmologServer.class, args);
		
		System.out.println("App running...");
	}
	
}

