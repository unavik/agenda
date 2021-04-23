package com.unavik.agenda.dto.response;

import java.util.Date;

/**
 * @author CAAC
 */
public class RestMessageDto {

    /**
     * Message.
     */
    private String message;

    /**
     * Date when occurs error.
     */
    private Date timestamp = new Date();

    /**
     * Constructor.
     * @param message message
     */
    public RestMessageDto(final String message) {
        this.message = message;
    }

    /**
     * Get Message.
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Get timestamp.
     * @return timestamp
     */
    public Long getTimestamp() {
        return timestamp.getTime();
    }
}
