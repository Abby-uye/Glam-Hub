package com.beautyClan.glamhub.data.models;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Address {
    private String country;
    private String state;
    private String city;
    private String street;
//    private int postalCode;
    private  int buildingNumber;
}
