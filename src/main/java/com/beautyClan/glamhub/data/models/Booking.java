package com.beautyClan.glamhub.data.models;

import com.beautyClan.glamhub.enums.BookingStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate dateBooked = LocalDate.now();
    private LocalDate appointmentDate;
    private BookingStatus bookingStatus;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "makeup_artist_id")
    private MakeupArtist makeupArtist;

}
