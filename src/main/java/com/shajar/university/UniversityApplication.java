package com.shajar.university;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class UniversityApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversityApplication.class, args);
	}

	@Bean
	@Profile("dev")
	CommandLineRunner runDev(){
		return args -> {
			System.out.println("************* Start ***************");
			System.out.println("*********Dev Environment **********");
		};
	}
	@Bean
	@Profile("prod")
	CommandLineRunner runProd(){
		return args -> {
			System.out.println("************* Start ***************");
			System.out.println("*********Prod Environment **********");
		};
	}
}
