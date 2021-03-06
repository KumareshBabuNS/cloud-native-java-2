package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CloudFoundryTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudFoundryTestApplication.class, args);
	}
}

@RefreshScope
@RestController
class MessageRestController {

	@Value("${configuration.projectName:Config default}")
	private String message;

	@RequestMapping("/message")
	String getMessage() {
		return this.message;
	}
}