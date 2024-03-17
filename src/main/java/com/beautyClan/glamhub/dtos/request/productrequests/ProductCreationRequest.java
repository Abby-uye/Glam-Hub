package com.beautyClan.glamhub.dtos.request.productrequests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
@Setter
@Getter
public class ProductCreationRequest {
    @NotBlank(message = "Required field")
    private String name;
//    @NotNull(message = "Required field")
//    private Date manufacturingDate;
//    @NotNull(message = "Required field")
//    private Date expiryDate;

    @NotNull(message = "Required field")
    private Integer quantity;
    @NotNull(message = "Required field")
    private BigDecimal price;

}
