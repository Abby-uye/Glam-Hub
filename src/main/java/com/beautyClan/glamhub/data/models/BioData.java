package com.beautyClan.glamhub.data.models;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class BioData {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}

