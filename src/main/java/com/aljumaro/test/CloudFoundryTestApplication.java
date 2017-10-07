package com.aljumaro.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class CloudFoundryTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudFoundryTestApplication.class, args);
	}
}