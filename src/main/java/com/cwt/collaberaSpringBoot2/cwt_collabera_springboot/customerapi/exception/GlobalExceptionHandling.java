package com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

@RestControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler
    public ResponseEntity<String> customerNotFoundler(CustomerNotFoundException customerNotFoundException){
        return  new ResponseEntity<>(customerNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler
    public ResponseEntity<String> sqlExceptionHandler(SQLException sqlException){
        return  new ResponseEntity<>(sqlException.getMessage(), HttpStatus.NOT_FOUND);
    }
}
