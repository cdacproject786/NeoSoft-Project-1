package com.admin.pojo;

public class TransportDetails {

    private int transporterId;
    private String name;
    private String city;

    private String role;

    private String email;
    private String password;


    public TransportDetails(int transporterId, String name, String city, String role, String email, String password) {
        this.transporterId = transporterId;
        this.name = name;
        this.city = city;
        this.role = role;
        this.email = email;
        this.password = password;
    }

    public TransportDetails() {
    }

    public int getTransporterId() {
        return transporterId;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setTransporterId(int transporterId) {
        this.transporterId = transporterId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
