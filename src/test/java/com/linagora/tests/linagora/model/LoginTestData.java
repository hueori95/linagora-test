package com.linagora.tests.linagora.model;


public class LoginTestData {
    private String username;
    private String password;

    public LoginTestData() {
    }

    public LoginTestData(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


}