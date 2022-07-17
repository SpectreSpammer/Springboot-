package com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.dto;

import com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.entity.Address;
import com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.entity.Customer;
import com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private Integer custId;
//   @NotBlank(message = "First Name can`t be null/blank")
    private  String firstName;
//    @NotBlank(message = "Last Name can`t be null/blank")
    private String lastName;
//    @NotBlank(message = "Email is invalid, please use proper format for email")
    private String email;
//    @Embedded
    @Valid
    private AddressDTO addressDTO;
    private List<OrdersDTO> ordersDTO;
    //orders2dto
    /*
    @Embedded
    @Valid
    private Orders2DTO orders2DTO;
    */
    @PastOrPresent
    private LocalDate dob;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    /*
    Model mapper dependency
    it helps to convert from dto to entity and vice versa
     */
    public CustomerDTO(Customer customer){
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.email = customer.getEmail();
        //For address
        /*
        Address customerAddress = customer.getAddress();
        AddressDTO addressDTO1 = new AddressDTO(customerAddress);
        */
//        this.addressDTO = new AddressDTO(customer.getAddress());
        Address customerAddress = customer.getAddress();
        this.addressDTO = new AddressDTO(customer.getAddress());
        this.addressDTO.setCity(customerAddress.getCity());
        this.addressDTO.setCountry(customerAddress.getCountry());
        //working
        /*
        this.orders2DTO = new Orders2DTO(customer.getOrders2());
        */

        List<Orders> ordersList = customer.getOrders();
        this.ordersDTO = new ArrayList<>();
        for (Orders orders : ordersList) {
            OrdersDTO ordersDTO = new OrdersDTO();
            ordersDTO.setOrderName(orders.getOrderName());
            ordersDTO.setDescription(orders.getDescription());
            ordersDTO.setPrice(orders.getPrice());
            this.ordersDTO.add(ordersDTO);
        }

        this.dob = customer.getDob();
        this.createdOn = customer.getCreatedOn();
        this.updatedOn = customer.getUpdatedOn();
    }


}
