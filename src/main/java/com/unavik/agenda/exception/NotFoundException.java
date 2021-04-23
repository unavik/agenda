package com.unavik.agenda.exception;

public class NotFoundException extends RuntimeException {

    /**
     * Message to exception.
     */
    private String message;

    /**
     * Constructor.
     * @param message message of exception
     */
    public NotFoundException(final String message) {
        this.message = message;
    }

    /**
     * Get Message.
     * @return message
     */
    @Override
    public String getMessage() {
        return message;
    }
}
