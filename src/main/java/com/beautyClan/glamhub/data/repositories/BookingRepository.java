package com.beautyClan.glamhub.data.repositories;

import com.beautyClan.glamhub.data.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
