package com.lifenautjoe.bol.domain.exceptions;

public class GameNotStartedException extends RuntimeException {
    public GameNotStartedException() {

    }

    public GameNotStartedException(String message) {
        super(message);
    }

    public GameNotStartedException(Throwable cause) {
        super(cause);
    }

    public GameNotStartedException(String message, Throwable cause) {
        super(message, cause);
    }
}
