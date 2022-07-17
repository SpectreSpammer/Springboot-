package com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.entity;

import com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.dto.OrdersDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Entity
@Table(name = "cwt_orders")
public class Orders {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer orderId;

    private String orderName;
    private String description;
    private Double price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;



    public Orders(OrdersDTO ordersDTO){
        this.orderName = ordersDTO.getOrderName();
        this.description = ordersDTO.getDescription();
        this.price = ordersDTO.getPrice();

    }

    //Orders entity
    /*
      public OrderEntity(OrderDTO orderDTO) {
        this.orderName = orderDTO.getOrderName();
        this.description = orderDTO.getDescription();
        this.price = orderDTO.getPrice();
        CustomerDTO customerDTO = orderDTO.getCustomerDTO();
        customer = new Customer(customerDTO);
    }
     */


//    //Getter and Setter for customer
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
}
