package com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.controller;


import com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.dto.OrdersDTO;
import com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {


    @Autowired
    private OrdersService ordersService;

    @PostMapping("/placeOrder")
    public ResponseEntity<?> placeOrder(@RequestBody OrdersDTO orderDTO){
       return new ResponseEntity<>(ordersService.saveOrder(orderDTO), HttpStatus.CREATED);
    }

    @GetMapping("/findAllOrders")
    public List<OrdersDTO> findAllOrders(){
        return  ordersService.getAllOrders();
    }



}
