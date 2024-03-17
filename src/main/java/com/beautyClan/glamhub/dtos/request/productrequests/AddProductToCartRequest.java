package com.beautyClan.glamhub.dtos.request.productrequests;

import com.beautyClan.glamhub.data.models.Product;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddProductToCartRequest {
    private Product product;
    private Long Quantity;
}
