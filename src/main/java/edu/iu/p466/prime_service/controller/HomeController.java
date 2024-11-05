package edu.iu.p466.prime_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HomeController {
    Logger logger = LoggerFactory.getLogger(HomeController.class);
    @GetMapping
    public String greetings() {
        logger.info("in greetings");
        return "Welcome to the primes service!";
    }
}
