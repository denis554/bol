package com.lifenautjoe.bol.domain.exceptions;

public class GameIsNotFullException extends RuntimeException {
    public GameIsNotFullException() {

    }

    public GameIsNotFullException(String message) {
        super(message);
    }

    public GameIsNotFullException(Throwable cause) {
        super(cause);
    }

    public GameIsNotFullException(String message, Throwable cause) {
        super(message, cause);
    }
}
