package com.example.simpleapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.example.simpleapp.repository")
@EntityScan("com.example.simpleapp.model")
@SpringBootApplication
public class SimpleappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleappApplication.class, args);
	}

}
