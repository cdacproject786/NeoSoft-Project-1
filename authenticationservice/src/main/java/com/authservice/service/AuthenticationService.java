package com.authservice.service;

import com.authservice.IFeign.AdminFeign;
import com.authservice.entity.AuthUser;
import com.authservice.pojo.Admin;
import com.authservice.repository.AuthUserRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {


    @Autowired
    private AuthUserRepository authUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AdminFeign adminFeign;


    public AuthUser saveUser(AuthUser user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
       return authUserRepository.save(user);
    }

    public void trnasferAdmin(AuthUser authAdmin)
    {
        Admin admin = new Admin(authAdmin.getEmail(),authAdmin.getPassword());
        System.out.println("Before sending remote");
        adminFeign.registerAdmin(admin);
        System.out.println("Admin sending remote");
    }


}
