package com.example.CabinetMedical.Security;


public class SignInRequest {

    private String username;
    private String password;

    public SignInRequest() {
    }

    public SignInRequest(String email, String password) {
        this.username = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
