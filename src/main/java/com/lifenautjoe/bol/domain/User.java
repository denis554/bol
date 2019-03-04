package com.lifenautjoe.bol.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lifenautjoe.bol.domain.exceptions.UserHasNoGameException;
import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;
import java.util.Objects;

public class User implements Cloneable, Serializable {
    private String name;
    private Game game;

    public User(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!User.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final User other = (User) obj;
        if ((name == null) ? (other.name != null) : !name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public User clone() {
        return SerializationUtils.clone(this);
    }

    public String getName() {
        return name;
    }

    public void setGame(Game game) {
        this.game = game;
        game.addUser(this);
    }

    public GamePlayOutcome playGameAtSlotWithId(int slotId) {
        if (!hasGame()) {
            throw new UserHasNoGameException();
        }
        return game.playAtSlotWithIdForUser(slotId, this);
    }

    public boolean hasGame() {
        return game != null;
    }

    public boolean currentGameIsFull() {
        return game.isFull();
    }

    public boolean currentGameStarted() {
        return game.isGameStarted();
    }

    public boolean hasCurrentGameNextTurn() {
        return game.userHasNextTurn(this);
    }

    public boolean currentGameCanBePlayedWithSlotAtId(int slotId) {
        return !game.slotWithIdIsEmpty(slotId) && game.slotWithIdBelongsToUser(slotId, this);
    }

    public boolean hasGameWithName(String gameName) {
        if (!hasGame()) return false;
        return game.getName().equals(gameName);
    }

    public GamePlayOutcome terminateGame() {
        Game game = getGame();
        GamePlayOutcome gamePlayOutcome = game.terminateGameForUser(this);
        return gamePlayOutcome;
    }

    public GamePlayOutcome startGame() {
        Game game = getGame();
        GamePlayOutcome gamePlayOutcome = game.startGame();
        return gamePlayOutcome;
    }

    public String getGameName() {
        Game game = getGame();
        return game.getName();
    }

    public void removeGame() {
        game = null;
    }

    private Game getGame() {
        if (!hasGame()) {
            throw new UserHasNoGameException();
        }
        return game;
    }
}
