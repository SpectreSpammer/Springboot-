package com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.service;



import com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.dto.CustomerDTO;
import com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.entity.Customer;

import java.util.List;

public interface CustomerService {

    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomersById(Integer custId);
    void delCustomer(Integer custId);
    CustomerDTO updateCustomer(Customer customer, Integer custId);
    void delAllCustomers();


}
