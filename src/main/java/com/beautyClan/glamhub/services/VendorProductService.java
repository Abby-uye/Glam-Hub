package com.beautyClan.glamhub.services;

import com.beautyClan.glamhub.dtos.request.productrequests.ProductCreationRequest;
import com.beautyClan.glamhub.dtos.request.productrequests.ProductDeletionRequest;
import com.beautyClan.glamhub.utils.ApiResponse;

public interface VendorProductService {
    ApiResponse addProduct (String creatorEmail, ProductCreationRequest productCreationRequest);
    ApiResponse removeProduct(String removerEmail, ProductDeletionRequest request);
}
