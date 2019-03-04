package com.lifenautjoe.bol.domain;


import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class GameSlot implements Cloneable, Serializable {
    private final int id;
    private LinkedList<GameSlotStone> stones;

    public GameSlot(int id, LinkedList<GameSlotStone> stones) {
        this.id = id;
        this.stones = stones;
    }

    public int getId() {
        return id;
    }

    public boolean isEmpty() {
        return stones == null || stones.isEmpty();
    }

    public void dropStone(GameSlotStone stone) {
        this.stones.add(stone);
    }

    public void dropStones(List<GameSlotStone> stones) {
        for (GameSlotStone stone : stones) {
            this.dropStone(stone);
        }
    }

    public LinkedList<GameSlotStone> pickStones() {
        // Return clone
        LinkedList<GameSlotStone> stonesClone = (LinkedList<GameSlotStone>) stones.clone();
        stones.clear();
        return stonesClone;
    }

    public LinkedList<GameSlotStone> getStones() {
        return stones;
    }

    @Override
    public GameSlot clone() {
        return SerializationUtils.clone(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!GameSlot.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final GameSlot other = (GameSlot) obj;

        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return this.id;
    }

}
