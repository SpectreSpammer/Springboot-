package com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.entity;


import com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.dto.AddressDTO;
import com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.dto.CustomerDTO;
import com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.dto.OrdersDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cwt_customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer custId;
    @Column(name = "first_name",length = 20,updatable = true)
    private  String firstName;
    private String lastName;
    @Column(name = "email",length = 255,unique = true,nullable = false)
    private String email;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Orders> orders;
    @Embedded
    private Address address;
    //orders2
    /*
    @Embedded
    private Orders2 orders2;
    */
    private LocalDate dob;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    /*
    public Customer(CustomerDTO customerDTO){
        this.firstName = customerDTO.getFirstName();
        this.lastName = customerDTO.getLastName();
        this.email = customerDTO.getEmail();

        //for Address
        AddressDTO addressDTO = customerDTO.getAddressDTO();
        Address address1 = new Address(addressDTO);
        this.address = address1;

        //for Orders2
        Orders2DTO orders2DTO = customerDTO.getOrders2DTO();
        Orders2 orders21 = new Orders2(orders2DTO);
        this.orders2 = orders21;

        this.dob = customerDTO.getDob();
    }
    */
    public Customer(CustomerDTO customerDTO){
        this.firstName = customerDTO.getFirstName();
        this.lastName = customerDTO.getLastName();
        this.email = customerDTO.getEmail();

        //for address
        AddressDTO addressDTO = customerDTO.getAddressDTO();
        this.address = new Address();
        this.address.setCity(addressDTO.getCity());
        this.address.setCountry(addressDTO.getCountry());

        //for orders2
        /*
        Orders2DTO orders2DTO = customerDTO.getOrders2DTO();
        this.orders2 = new Orders2();
        this.orders2.setOrderName(orders2DTO.getOrderName());
        this.orders2.setDescription(orders2DTO.getDescription());
        this.orders2.setPrice(orders2DTO.getPrice());
        */
        List<OrdersDTO> ordersDTOList = customerDTO.getOrdersDTO();
        this.orders = new ArrayList<>();
        for(OrdersDTO ordersDTO : ordersDTOList){
            Orders orders1 = new Orders();
            orders1.setOrderName(orders1.getOrderName());
            orders1.setDescription(orders1.getDescription());
            orders1.setPrice(orders1.getPrice());
            this.orders.add(orders1);
        }

        this.dob = customerDTO.getDob();
        this.createdOn = customerDTO.getCreatedOn();
        this.updatedOn = customerDTO.getUpdatedOn();
    }


    @PrePersist
    public void created_On(){
        this.createdOn = LocalDateTime.now();
    }

    @PostUpdate
    public void updated_on(){
        this.updatedOn = LocalDateTime.now();
    }
}
