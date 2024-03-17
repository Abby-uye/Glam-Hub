package com.beautyClan.glamhub.data.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BeautyVendor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Embedded
    private  BioData bioData;
    @Embedded
    private Address address;
    private Date dateOfBirth;
    private transient boolean isLoggedIn;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Product> listOfProducts;
    @OneToMany
    private List<Transaction> listOfTransactions;
}

