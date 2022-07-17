package com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.controller;



import com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.dto.CustomerDTO;
import com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.service.CustomerService;
import com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.service.ValidatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/customer")
@Slf4j
public class customerController {

    @Autowired
    private ValidatorService validatorService;

    @Autowired
    private CustomerService customerService;

    /*
    @Valid  BindingResult bindingResult
    */

    /*
   public ResponseEntity<CustomerDTO> createdCustomer(@Valid @RequestBody CustomerDTO customerDTO,BindingResult bindingResult ){
    */
      @PostMapping("/create")
      public ResponseEntity<?> createdCustomer(@Valid @RequestBody CustomerDTO customerDTO,BindingResult bindingResult ){
       /*
         return new ResponseEntity<>(customerService.saveCustomer(customerDTO), HttpStatus.CREATED);
        */
       Map<String,String> errorMap = validatorService.validate(bindingResult);
       if(errorMap.isEmpty()){
            return new ResponseEntity<>(customerService.saveCustomer(customerDTO), HttpStatus.CREATED);
       }else{
           return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
       }
       /*
       log.info("CustomerDTO object {}" + customerDTO);
        */

    }

    @GetMapping("/getAll")
    public List<CustomerDTO> getCustomers(){
        return customerService.getAllCustomers();
    }


    @GetMapping("/{id}")
    public CustomerDTO getCustomersById(@PathVariable Integer id){
       return  customerService.getCustomersById(id);
    }

    /*
    @GetMapping("/customer/{id}/orders")
    public List<OrderEntity> getOrderByCust(@PathVariable("id") Integer id){
       return  customerService.getOrdersByCust(id);

    }
    */

}
