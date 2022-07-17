package com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.dto;

import com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDTO {

    private Integer orderId;
    @NotBlank(message = "Order name can`t be null/blank")
    private String orderName;

    @NotBlank(message = "Description can`t be null/blank")
    private String description;

    @NotBlank(message = "price can`t be null/blank")
    private Double price;



    public OrdersDTO(Orders orders){
        this.orderId = orders.getOrderId();
        this.orderName = orders.getOrderName();
        this.description = orders.getDescription();
        this.price = orders.getPrice();

    }

}
