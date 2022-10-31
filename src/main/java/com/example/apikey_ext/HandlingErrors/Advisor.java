package com.example.apikey_ext.HandlingErrors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Advisor {

    @ExceptionHandler(UnauthenticatedException.class)
public ResponseEntity<String> handlingAllErrors(UnauthenticatedException ex){
    return new ResponseEntity<String>(ex.getMessage(), HttpStatus.FORBIDDEN);
    }

}
