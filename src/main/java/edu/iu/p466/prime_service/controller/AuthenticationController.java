package edu.iu.p466.prime_service.controller;

import edu.iu.p466.prime_service.model.Customer;
import edu.iu.p466.prime_service.service.IAuthenticationService;
import edu.iu.p466.prime_service.service.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final IAuthenticationService authenticationService;

    private TokenService tokenService;


    public AuthenticationController(AuthenticationManager authenticationManager,
                                    IAuthenticationService authenticationService,
                                    TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.authenticationService = authenticationService;
        this.tokenService = tokenService;
    }


    @PostMapping("/register")
    public boolean register(@RequestBody Customer customer) {
        try {
            authenticationService.register(customer);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody Customer customer) {
            Authentication authentication = authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    customer.getUsername()
                                    , customer.getPassword()));

                return tokenService.generateToken(authentication);
    }


}
