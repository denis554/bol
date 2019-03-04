package com.lifenautjoe.bol.domain.exceptions;

public class GameFullException extends RuntimeException {
    public GameFullException() {

    }

    public GameFullException(String message) {
        super(message);
    }

    public GameFullException(Throwable cause) {
        super(cause);
    }

    public GameFullException(String message, Throwable cause) {
        super(message, cause);
    }
}
