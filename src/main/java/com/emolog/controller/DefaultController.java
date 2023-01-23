package com.emolog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
	
	@RequestMapping(value = "/")
	public String hello() {
		return "Hello World<br>No";
	}
}
