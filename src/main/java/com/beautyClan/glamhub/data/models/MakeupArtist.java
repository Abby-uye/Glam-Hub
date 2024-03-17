package com.beautyClan.glamhub.data.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MakeupArtist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
  private   Long id;
    @Embedded
    private BioData profile;
    @Embedded
   private Portfolio portfolio;
   private Date dateOfBirth;
    @OneToMany(fetch = FetchType.EAGER)
   private List<Booking> listOfBookings;
    @OneToMany
   private List<Transaction> listOfTransaction;
}
