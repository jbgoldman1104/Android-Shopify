package com.example.nextapp;

public class User {
    private String userName,phoneNo,Email,password;

    public User() {
    }

    public User( String userName, String phoneNo, String email, String password) {

        this.userName = userName;
        this.phoneNo = phoneNo;
        this.Email = email;
        this.password = password;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
