package com.plimadev.virtus.exception;  // you can choose a package like `exception`

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.converter.HttpMessageNotReadableException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleBadRequest(HttpMessageNotReadableException ex) {
        ex.printStackTrace();  // logs full cause to console
        return ResponseEntity.badRequest()
                .body("Invalid JSON: " + ex.getMostSpecificCause().getMessage());
    }
}
