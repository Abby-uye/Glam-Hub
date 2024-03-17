package com.beautyClan.glamhub.data.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
@Embeddable
public class Portfolio {
    private String portFolioName;
    @Embedded
    private Address address;
}
