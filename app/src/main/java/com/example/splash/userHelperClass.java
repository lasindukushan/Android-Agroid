package com.example.splash;

public class userHelperClass {

    String name,username,district,phoneNo,password;

    public userHelperClass(String name, String username, String district, String phoneNo, String password) {
        this.name = name;
        this.username = username;
        this.district = district;
        this.phoneNo = phoneNo;
        this.password = password;
    }

    public userHelperClass(){

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
