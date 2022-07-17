package com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.service;

import com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.dto.OrdersDTO;
import com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.entity.Orders;
import com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;


    @Override
    public OrdersDTO saveOrder(OrdersDTO ordersDTO) {
        Orders orders = ordersRepository.save(new Orders(ordersDTO));
        return new OrdersDTO(orders);
    }



    @Override
    public List<OrdersDTO> getAllOrders() {
        List<OrdersDTO> dtoList = ordersRepository.findAll().stream().map(OrdersDTO::new).collect(Collectors.toList());
        return dtoList;
    }
}
