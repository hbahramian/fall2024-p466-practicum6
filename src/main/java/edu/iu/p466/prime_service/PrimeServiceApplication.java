package edu.iu.p466.prime_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrimeServiceApplication {
	@Value("${spring.datasource.url}")
	private static String datasourceUrl;

	public static void main(String[] args) {
		System.out.println("Database URL: " + datasourceUrl);


		SpringApplication.run(PrimeServiceApplication.class, args);
	}

}
