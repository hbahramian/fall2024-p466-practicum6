package edu.iu.p466.prime_service.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.*;

class PrimeServiceTest {

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