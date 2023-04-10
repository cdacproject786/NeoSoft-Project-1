package com.authservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AuthUser {

    @Id
    private String email;

    private String password;

    public AuthUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public AuthUser() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
