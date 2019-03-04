package com.lifenautjoe.bol.controllers.users.requests;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginRequestBody {

    @NotNull
    @Size(min = 3, max = 12)
    @Pattern(regexp = "^[a-zA-Z0-9 ]*")
    private String userName;

    public LoginRequestBody() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
