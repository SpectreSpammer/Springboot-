package com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.service;

import com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.dto.OrdersDTO;

import java.util.List;

public interface OrdersService {

    OrdersDTO saveOrder(OrdersDTO orderDTO);

    List<OrdersDTO> getAllOrders();
}
