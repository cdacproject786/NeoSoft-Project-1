package com.admin.pojo;

public class User {

    private int id;
    private String fname;
    private String lname;
    private String city;
    private String mobileNo;
    private String email;
    private String password;
    private String role;

    public User(int id, String fname, String lname, String city, String mobileNo, String email, String password, String role) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.city = city;
        this.mobileNo = mobileNo;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getCity() {
        return city;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
