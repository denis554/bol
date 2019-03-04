package com.lifenautjoe.bol.services.users.exceptions;

public class SessionAlreadyHasUserException extends RuntimeException {
    public SessionAlreadyHasUserException() {

    }

    public SessionAlreadyHasUserException(String message) {
        super(message);
    }

    public SessionAlreadyHasUserException(Throwable cause) {
        super(cause);
    }

    public SessionAlreadyHasUserException(String message, Throwable cause) {
        super(message, cause);
    }
}
