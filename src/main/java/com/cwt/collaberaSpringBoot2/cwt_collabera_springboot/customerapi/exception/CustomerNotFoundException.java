package com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
