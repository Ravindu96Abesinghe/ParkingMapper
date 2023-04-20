package com.example.myapplication;

public class User {

    private String Email, Password, UserType;

    public User(String email, String password) {
        Email = email;
        Password = password;
    }

    public User() {
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = UserType;
    }
}
