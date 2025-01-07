package com.daliborstakic.airways;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.daliborstakic.airways.repositories")
@SpringBootApplication(scanBasePackages = "com.daliborstakic.airways")
@EntityScan("com.daliborstakic.airways.model")
public class AirwaysMapApplication {
	public static void main(String[] args) {
		SpringApplication.run(AirwaysMapApplication.class, args);
	}
}
