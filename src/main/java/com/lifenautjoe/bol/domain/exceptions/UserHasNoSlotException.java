package com.lifenautjoe.bol.domain.exceptions;

public class UserHasNoSlotException extends RuntimeException {
    public UserHasNoSlotException() {

    }

    public UserHasNoSlotException(String message) {
        super(message);
    }

    public UserHasNoSlotException(Throwable cause) {
        super(cause);
    }

    public UserHasNoSlotException(String message, Throwable cause) {
        super(message, cause);
    }
}
