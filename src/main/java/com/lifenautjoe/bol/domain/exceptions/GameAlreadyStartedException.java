package com.lifenautjoe.bol.domain.exceptions;

public class GameAlreadyStartedException extends RuntimeException {
    public GameAlreadyStartedException() {

    }

    public GameAlreadyStartedException(String message) {
        super(message);
    }

    public GameAlreadyStartedException(Throwable cause) {
        super(cause);
    }

    public GameAlreadyStartedException(String message, Throwable cause) {
        super(message, cause);
    }
}
