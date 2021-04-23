package com.unavik.agenda.controller;

import com.unavik.agenda.dto.response.RestMessageDto;
import com.unavik.agenda.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<RestMessageDto> handleIllegalArgument(final NotFoundException ex) {
        LOGGER.error(ex.getMessage());
        return new ResponseEntity<>(new RestMessageDto(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

}
