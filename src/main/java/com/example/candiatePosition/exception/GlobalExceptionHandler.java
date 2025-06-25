package com.example.candiatePosition.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        log.info("Exception Occured inside method : handleValidationErrors()");

        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleResourceNotFound(ResourceNotFoundException ex) {
        log.info("Exception Occured inside method : handleResourceNotFound()");

        Map<String, String> error = new HashMap<>();
        error.put("errorMessage", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handelRuntimeException(RuntimeException ex) {
        log.info("Exception Occured inside method : handelRuntimeException()");

        Map<String, String> error = new HashMap<>();
        error.put("errorMessage", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}