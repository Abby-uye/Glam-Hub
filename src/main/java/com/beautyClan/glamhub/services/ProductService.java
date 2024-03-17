package com.beautyClan.glamhub.services;

import com.beautyClan.glamhub.data.models.Product;
import com.beautyClan.glamhub.dtos.request.productrequests.GetProductRequest;
import com.beautyClan.glamhub.dtos.request.productrequests.ProductCreationRequest;
import com.beautyClan.glamhub.dtos.request.productrequests.ProductDeletionRequest;
import com.beautyClan.glamhub.utils.ApiResponse;

public interface ProductService {
    Product getProduct(GetProductRequest productRequest);
}
