package edu.iu.p466.prime_service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PrimeServiceApplicationTests {

	@Value("${spring.datasource.url}")
	private String datasourceUrl;

	@Value("${spring.datasource.username}")
	private String datasourceUsername;

	@Value("${spring.datasource.password}")
	private String datasourcePassword;

	@Test
    void logDBConnection() {
		System.out.println("Database URL: " + datasourceUrl);
		System.out.println("Database username: " + datasourceUsername);
		System.out.println("Database password: " + datasourcePassword);
	}

	@Test
	void contextLoads() {
	}

}
