package com.lifenautjoe.bol.domain.exceptions;

public class SlotIsEmptyException extends RuntimeException {
    public SlotIsEmptyException() {

    }

    public SlotIsEmptyException(String message) {
        super(message);
    }

    public SlotIsEmptyException(Throwable cause) {
        super(cause);
    }

    public SlotIsEmptyException(String message, Throwable cause) {
        super(message, cause);
    }
}
