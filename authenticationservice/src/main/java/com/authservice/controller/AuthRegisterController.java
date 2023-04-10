package com.authservice.controller;

import com.authservice.entity.AuthUser;
import com.authservice.service.AuthenticationService;
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
    public ResponseEntity<?> saveAdmin(@RequestBody AuthUser user)
    {
        try
        {
            AuthUser savedUser =  authenticationService.saveUser(user);
            System.out.println("Saved the data to local db");
            authenticationService.trnasferAdmin(savedUser);
            System.out.println("Saved the data to remote db");
            return new ResponseEntity<>(new String("Saved Successfully"), HttpStatus.OK);
        }

        catch(Exception e)
        {
            e.printStackTrace();
            return new ResponseEntity<>(new String("Unresolved Problem"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/encode")
    public void encode(@RequestBody AuthUser user)
    {
        System.out.println(encoder.encode(user.getPassword()));
    }
}
