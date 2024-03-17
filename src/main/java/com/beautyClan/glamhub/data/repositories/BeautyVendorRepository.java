package com.beautyClan.glamhub.data.repositories;

import com.beautyClan.glamhub.data.models.BeautyVendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeautyVendorRepository extends JpaRepository<BeautyVendor,Long> {
    BeautyVendor findByBioData_EmailEquals(String email);
}
