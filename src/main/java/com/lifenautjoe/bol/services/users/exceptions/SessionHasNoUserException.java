package com.lifenautjoe.bol.services.users.exceptions;

public class SessionHasNoUserException extends RuntimeException {
    public SessionHasNoUserException() {

    }

    public SessionHasNoUserException(String message) {
        super(message);
    }

    public SessionHasNoUserException(Throwable cause) {
        super(cause);
    }

    public SessionHasNoUserException(String message, Throwable cause) {
        super(message, cause);
    }
}
