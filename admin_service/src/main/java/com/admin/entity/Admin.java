package com.admin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Admin {
    @Id
    private String email;
    private String Password;

    public Admin(String email, String password) {
        this.email = email;
        Password = password;
    }

    public Admin() {
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return Password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
