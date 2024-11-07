package edu.iu.p466.prime_service.controller;

import edu.iu.p466.prime_service.service.IPrimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.oauth2.jwt.Jwt;
import edu.iu.p466.prime_service.rabbitmq.MQSender;


@RestController
@CrossOrigin
@RequestMapping("/primes")
public class PrimesController {

    Logger logger = LoggerFactory.getLogger(PrimesController.class);

    IPrimeService primeService;
    private final MQSender mqSender;
    public PrimesController(IPrimeService primeService, MQSender mqSender) {
        this.primeService = primeService;
        this.mqSender = mqSender;
    }

    @GetMapping
    public String greetings() {
        logger.info("in PrimesController greetings");
        return "Welcome to the PrimesController!";
    }

    @GetMapping("/{n}")
    public boolean isPrime(@PathVariable int n) {
        logger.info("in isPrime");
        boolean result = primeService.isPrime(n);
        Object principal = SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        String username = ((Jwt) principal).getSubject();
        System.out.println(username);
        try {
            mqSender.sendMessage(username, n, result);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return result;
    }



}
