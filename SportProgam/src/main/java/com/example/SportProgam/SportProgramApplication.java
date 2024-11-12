package com.example.SportProgam;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition
@SpringBootApplication
public class SportProgramApplication {
	public static void main(String[] args) {
		SpringApplication.run(SportProgramApplication.class, args);
	}
}
