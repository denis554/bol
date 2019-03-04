package com.lifenautjoe.bol.controllers.games.requests;

import javax.validation.constraints.*;

public class GamePlayRequest {

    @NotNull
    @Max(14)
    @Min(1)
    private int slotId;

    @NotNull
    @Size(min = 3, max = 12)
    @Pattern(regexp = "^[a-zA-Z0-9 ]*")
    private String gameName;

    public GamePlayRequest() {

    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
}
