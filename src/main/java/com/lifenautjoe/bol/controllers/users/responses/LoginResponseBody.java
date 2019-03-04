package com.lifenautjoe.bol.controllers.users.responses;

public class LoginResponseBody {
    private String userName;

    public LoginResponseBody(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
