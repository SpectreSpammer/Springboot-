package com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class ValidatorService {

    public Map<String,String> validate(BindingResult bindingResult){
        Map<String,String> map = new HashMap<>();

        for (FieldError fieldError :  bindingResult.getFieldErrors()){
            map.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        return map;
    }
}
