package com.beautyClan.glamhub.services;

import com.beautyClan.glamhub.data.models.Customer;
import com.beautyClan.glamhub.dtos.request.customerrequests.CustomerLoginRequest;
import com.beautyClan.glamhub.dtos.request.customerrequests.CustomerRegistrationRequest;
import com.beautyClan.glamhub.dtos.request.productrequests.AddProductToCartRequest;
import com.beautyClan.glamhub.exceptions.AlreadyExistException;
import com.beautyClan.glamhub.exceptions.InvalidCredentialsException;
import com.beautyClan.glamhub.utils.ApiResponse;

public interface CustomerService {
    ApiResponse register(CustomerRegistrationRequest request) throws AlreadyExistException;

    ApiResponse login(CustomerLoginRequest request) throws InvalidCredentialsException;

    ApiResponse addToCart(AddProductToCartRequest request);
}
