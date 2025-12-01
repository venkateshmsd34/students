package com.example.studentservice.config;

import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class demoConfig {
	
	public String hello() {
		return "Hello world and java ";
	}

}
