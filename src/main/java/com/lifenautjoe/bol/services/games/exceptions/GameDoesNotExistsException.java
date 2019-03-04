package com.lifenautjoe.bol.services.games.exceptions;

public class GameDoesNotExistsException extends RuntimeException {
    public GameDoesNotExistsException() {

    }

    public GameDoesNotExistsException(String message) {
        super(message);
    }

    public GameDoesNotExistsException(Throwable cause) {
        super(cause);
    }

    public GameDoesNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
