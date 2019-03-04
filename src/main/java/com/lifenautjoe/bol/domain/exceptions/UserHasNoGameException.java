package com.lifenautjoe.bol.domain.exceptions;

public class UserHasNoGameException extends RuntimeException {
    public UserHasNoGameException() {

    }

    public UserHasNoGameException(String message) {
        super(message);
    }

    public UserHasNoGameException(Throwable cause) {
        super(cause);
    }

    public UserHasNoGameException(String message, Throwable cause) {
        super(message, cause);
    }
}
