package com.lifenautjoe.bol.domain;

import java.util.List;

public class GamePlayOutcome {

    private boolean gameFinished;
    // Make sure they are copies!
    private String nextTurnHolderUserName;
    private String winnerUserName;
    private String gameName;
    private List<GameSlot> slots;
    private String userAName;
    private String userBName;
    private int userAScore;
    private int userBScore;

    public String getNextTurnHolderUserName() {
        return nextTurnHolderUserName;
    }

    public void setNextTurnHolderUserName(String nextTurnHolderUserName) {
        this.nextTurnHolderUserName = nextTurnHolderUserName;
    }

    public String getWinnerUserName() {
        return winnerUserName;
    }

    public void setWinnerUserName(String winnerUserName) {
        this.winnerUserName = winnerUserName;
    }

    public boolean isGameFinished() {
        return gameFinished;
    }

    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
    }

    public List<GameSlot> getSlots() {
        return slots;
    }

    public void setSlots(List<GameSlot> slots) {
        this.slots = slots;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getUserAName() {
        return userAName;
    }

    public void setUserAName(String userAName) {
        this.userAName = userAName;
    }

    public String getUserBName() {
        return userBName;
    }

    public void setUserBName(String userBName) {
        this.userBName = userBName;
    }

    public int getUserAScore() {
        return userAScore;
    }

    public void setUserAScore(int userAScore) {
        this.userAScore = userAScore;
    }

    public int getUserBScore() {
        return userBScore;
    }

    public void setUserBScore(int userBScore) {
        this.userBScore = userBScore;
    }
}
