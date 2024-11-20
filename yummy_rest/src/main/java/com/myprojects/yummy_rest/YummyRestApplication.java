package com.myprojects.yummy_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class YummyRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(YummyRestApplication.class, args);
	}

}
