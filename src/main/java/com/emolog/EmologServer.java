package com.emolog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;


//@EnableAutoConfiguration
//@EnableJpaRepositories
@SpringBootApplication
@ConfigurationPropertiesScan("com.emolog.configuration")
@EnableAutoConfiguration(exclude = { // remove later on
	    DataSourceAutoConfiguration.class,
	    DataSourceTransactionManagerAutoConfiguration.class,
	    HibernateJpaAutoConfiguration.class})
@ComponentScan(basePackages = { "com.emolog.service","com.emolog.controller", "com.emolog.model", "com.emolog.repository"} )
public class EmologServer {
//	private DiaryController dc = new DiaryController(new DiaryService());
	public static void main(String[] args) {
		SpringApplication.run(EmologServer.class, args);
		
		System.out.println("Hi");
	}
	
}

