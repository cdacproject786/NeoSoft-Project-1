package com.authservice.controller;

import com.authservice.entity.AuthUser;
import com.authservice.service.AuthenticationService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class AuthRegisterController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/admin")
    @Transactional
    @CircuitBreaker(name = "ADMIN_REGISTER_BREAKER",fallbackMethod = "regsiterfallback")
    public ResponseEntity<?> saveAdmin(@RequestBody AuthUser user)
    {
        try
        {
            AuthUser savedUser =  authenticationService.saveUser(user);
            // System.out.println("Saved the data to local db");
            authenticationService.trnasferAdmin(savedUser);
           // System.out.println("Saved the data to remote db");
            return new ResponseEntity<>(new String("Saved Successfully"), HttpStatus.OK);
        }

        catch(Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<>(new String("Unresolved Problem"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> registerfallback(AuthUser user,Exception e)
    {
        System.out.println("Fallback executed because service is down");
        return new ResponseEntity<>("The service is down. Try after some time",HttpStatus.SERVICE_UNAVAILABLE);
    }

}
