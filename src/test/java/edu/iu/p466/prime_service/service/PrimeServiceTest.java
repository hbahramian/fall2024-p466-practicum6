package edu.iu.p466.prime_service.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;
class PrimeServiceTest {

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