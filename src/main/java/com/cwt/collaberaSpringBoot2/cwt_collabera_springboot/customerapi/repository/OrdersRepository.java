package com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.repository;

import com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrdersRepository extends JpaRepository<Orders,Integer> {
}
