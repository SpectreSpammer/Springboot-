package com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.service;


import com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.dto.CustomerDTO;
import com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.entity.Customer;
import com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.exception.CustomerNotFoundException;
import com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CustomerServiceImpl  implements  CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        Customer cust =  customerRepository.save(new Customer(customerDTO));
        return new CustomerDTO(cust);
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> dtoList = customerRepository.findAll().stream().map(CustomerDTO::new).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public CustomerDTO getCustomersById(Integer custId) {
       Customer customer =  customerRepository.findById(custId).orElseThrow(() -> new CustomerNotFoundException("Customer Not Available with ID" + custId));
       return  new CustomerDTO(customer);
    }

    /*
    @Override
    public List<OrderEntity> getOrdersByCust(Integer custId) {
     return  customerRepository.getOrdersByCust(custId);
    }
    */



    @Override
    public void delCustomer(Integer custId) {

    }

    @Override
    public CustomerDTO updateCustomer(Customer customer, Integer custId) {
        return null;
    }

    @Override
    public void delAllCustomers() {

    }
}
