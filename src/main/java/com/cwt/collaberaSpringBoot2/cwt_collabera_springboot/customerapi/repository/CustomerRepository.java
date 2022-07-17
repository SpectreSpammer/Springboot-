package com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.repository;


import com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer,Integer> {


}
