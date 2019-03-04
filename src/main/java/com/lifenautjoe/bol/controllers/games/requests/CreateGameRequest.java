package com.lifenautjoe.bol.controllers.games.requests;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CreateGameRequest {
    @NotNull
    @Size(min = 3, max = 12)
    @Pattern(regexp = "^[a-zA-Z0-9 ]*")
    String gameName;

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
}
