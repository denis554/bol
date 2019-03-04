package com.lifenautjoe.bol.domain;

import java.io.Serializable;

public class GameSlotStone implements Serializable{
    private final int id;

    public GameSlotStone(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
