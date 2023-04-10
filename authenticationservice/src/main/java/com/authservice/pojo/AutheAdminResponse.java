package com.authservice.pojo;

public class AutheAdminResponse {

    private String email;
    private String token;

    public AutheAdminResponse(String email, String token) {
        this.email = email;
        this.token = token;
    }

    public AutheAdminResponse() {
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
