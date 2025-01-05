package com.dalibostakic.airways;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.dalibostakic.airways.repositories")
@EntityScan(basePackages = "com.daliborstakic.airways.model")
public class AirwaysMapApplication {
	public static void main(String[] args) {
		SpringApplication.run(AirwaysMapApplication.class, args);
	}
}
