package com.lifenautjoe.bol.domain.exceptions;

public class GameFinishedException extends RuntimeException {
    public GameFinishedException() {

    }

    public GameFinishedException(String message) {
        super(message);
    }

    public GameFinishedException(Throwable cause) {
        super(cause);
    }

    public GameFinishedException(String message, Throwable cause) {
        super(message, cause);
    }
}
