package com.lifenautjoe.bol.controllers.games.responses;

import com.lifenautjoe.bol.domain.Game;

public class GameResponse {
    private String name;
    private boolean isFull;

    public GameResponse(Game game) {
        name = game.getName();
        isFull = game.isFull();
    }

    public String getName() {
        return name;
    }

    public boolean isFull() {
        return isFull;
    }
}
