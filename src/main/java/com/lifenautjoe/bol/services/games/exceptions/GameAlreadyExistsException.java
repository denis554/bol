package com.lifenautjoe.bol.services.games.exceptions;

public class GameAlreadyExistsException extends RuntimeException {
    public GameAlreadyExistsException() {

    }

    public GameAlreadyExistsException(String message) {
        super(message);
    }

    public GameAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public GameAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
