package com.beautyClan.glamhub.data.models;

import com.beautyClan.glamhub.enums.AvailabilityStatus;
import com.beautyClan.glamhub.enums.Category;
import com.beautyClan.glamhub.enums.Review;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sku;
    private String name;
    private String manufacturingDate;
    private Date expiryDate;
    private Integer quantity;
    private AvailabilityStatus availabilityStatus;
    private Category category;
    private BigDecimal price;
//    @OneToMany
//    private List<Review> review;
    private Rating rating;
    @ManyToOne
    private BeautyVendor beautyVendor;
}
