package com.example.SportProgam;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition
@SpringBootApplication
@Slf4j
public class SportProgramApplication {
	public static void main(String[] args) {
		SpringApplication.run(SportProgramApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			log.info("Проверка перед запуском...");
			ApiConfig.checkData();
		};
	}
}
