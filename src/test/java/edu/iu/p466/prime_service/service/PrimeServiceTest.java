package edu.iu.p466.prime_service.service;

import org.junit.jupiter.api.Test;

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