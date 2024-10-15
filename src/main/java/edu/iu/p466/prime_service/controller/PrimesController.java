package edu.iu.p466.prime_service.controller;

import edu.iu.p466.prime_service.service.IPrimeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class PrimesController {

    IPrimeService primeService;
    public PrimesController(IPrimeService primeService) {
        this.primeService = primeService;
    }

    @GetMapping("/{n}")
    public boolean isPrime(@PathVariable int n) {
        return primeService.isPrime(n);
    }



}
