package com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.entity;

import com.cwt.collaberaSpringBoot2.cwt_collabera_springboot.customerapi.dto.AddressDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {
    private String city;
    private String country;


    public Address(AddressDTO addressDTO){
        this.city = addressDTO.getCity();
        this.country = addressDTO.getCountry();
    }
}
