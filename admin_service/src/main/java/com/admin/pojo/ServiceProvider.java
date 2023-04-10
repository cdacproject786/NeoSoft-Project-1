package com.admin.pojo;

public class ServiceProvider {

    private int id;
    private String firmName;
    private long mobNo;
    private String mailId;
    private String role;
    private String city;
    private String password;

    public ServiceProvider(int id, String firmName, long mobNo, String mailId, String role, String city, String password) {
        this.id = id;
        this.firmName = firmName;
        this.mobNo = mobNo;
        this.mailId = mailId;
        this.role = role;
        this.city = city;
        this.password = password;
    }

    public ServiceProvider() {
    }

    public int getId() {
        return id;
    }

    public String getFirmName() {
        return firmName;
    }

    public long getMobNo() {
        return mobNo;
    }

    public String getMailId() {
        return mailId;
    }

    public String getRole() {
        return role;
    }

    public String getCity() {
        return city;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public void setMobNo(long mobNo) {
        this.mobNo = mobNo;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
