package com.mcr.currenycconverterapiintegration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(IllegalArgumentException.class)
    public Map<String, Object> handleIllegalArgumentException(IllegalArgumentException e) {
        return Map.of("error", e.getMessage(), "status", HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(Exception.class)
    public Map<String, Object> handleGeneralException(Exception e) {
        return Map.of("error", "An unexpected error occurred", "status", HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
