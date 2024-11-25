package edu.iu.p466.prime_service.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

import static org.junit.jupiter.api.Assertions.*;

class PrimeServiceTest {

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.datasource.username}")
    private String datasourceUsername;

    @Value("${spring.datasource.password}")
    private String datasourcePassword;

    @Autowired
    private Environment environment;

    @Test
    void logDBConnection() {
        System.out.println("Database URL: " + datasourceUrl);
        System.out.println("Database URL: " + environment.getProperty("spring.datasource.url"));
        System.out.println("Database username: " + datasourceUsername);
        System.out.println("Database username: " + environment.getProperty("spring.datasource.username"));
        System.out.println("Database password: " + datasourcePassword);
        System.out.println("Database password: " + environment.getProperty("spring.datasource.password"));
    }

    @Test
    void _45IsNotPrime() {
        PrimeService primeService = new PrimeService();
        assertFalse(primeService.isPrime(45));
    }

    @Test
    void _285191IsNotPrime() {
        PrimeService primeService = new PrimeService();
        assertTrue(primeService.isPrime(285191));
    }
}