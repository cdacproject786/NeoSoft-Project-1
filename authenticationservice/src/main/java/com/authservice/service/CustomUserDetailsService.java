package com.authservice.service;

import com.authservice.config.CustomAuthUserObject;
import com.authservice.entity.AuthUser;
import com.authservice.repository.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthUserRepository authUserRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
     Optional<AuthUser>  user =  authUserRepository.findByEmail(email);
     return user.map(CustomAuthUserObject::new).orElseThrow(()->new UsernameNotFoundException("User Not found"));


    }
}
