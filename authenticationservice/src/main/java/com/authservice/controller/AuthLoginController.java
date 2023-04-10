package com.authservice.controller;

import com.authservice.config.CustomAuthUserObject;
import com.authservice.entity.AuthUser;
import com.authservice.jwt.JwtTokenUtil;
import com.authservice.pojo.Admin;
import com.authservice.pojo.AutheAdminResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthLoginController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @PostMapping("/user")
    public AutheAdminResponse loginAdmin(@RequestBody Admin admin) throws Exception
    {

     Authentication authenticate =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(admin.getEmail(),admin.getPassword()));

     if(authenticate.isAuthenticated()) {
         //generate access token here
         CustomAuthUserObject principalAdmin = (CustomAuthUserObject) authenticate.getPrincipal();
         String accesToken = jwtTokenUtil.generateAccessToken(principalAdmin);
         AutheAdminResponse response = new AutheAdminResponse(admin.getEmail(), accesToken);
         return response;
     }
     else
     {
         throw new Exception("Authentication was not successful");

     }


    }

    @GetMapping("/valid")
    public String validate()
    {
        return "Token is validated";
    }
}
