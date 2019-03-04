package com.lifenautjoe.bol.domain.exceptions;

public class UserHasNoNextTurnException extends RuntimeException {
    public UserHasNoNextTurnException() {

    }

    public UserHasNoNextTurnException(String message) {
        super(message);
    }

    public UserHasNoNextTurnException(Throwable cause) {
        super(cause);
    }

    public UserHasNoNextTurnException(String message, Throwable cause) {
        super(message, cause);
    }
}
