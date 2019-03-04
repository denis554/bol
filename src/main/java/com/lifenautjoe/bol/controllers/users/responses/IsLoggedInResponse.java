package com.lifenautjoe.bol.controllers.users.responses;

public class IsLoggedInResponse {
    private boolean loggedIn;
    private String userName;

    public IsLoggedInResponse(boolean loggedIn, String userName) {
        this.loggedIn = loggedIn;
        this.userName = userName;
    }

    public IsLoggedInResponse(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public String getUserName() {
        return userName;
    }
}
