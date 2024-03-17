package com.beautyClan.glamhub.services;

import com.beautyClan.glamhub.dtos.request.beautyvendorrequests.BeautyVendorLoginRequest;
import com.beautyClan.glamhub.dtos.request.beautyvendorrequests.BeautyVendorRegisterRequest;
import com.beautyClan.glamhub.exceptions.AlreadyExistException;
import com.beautyClan.glamhub.exceptions.DoesNotExistException;
import com.beautyClan.glamhub.exceptions.InvalidCredentialsException;
import com.beautyClan.glamhub.utils.ApiResponse;

public interface BeautyVendorService {
    ApiResponse register(BeautyVendorRegisterRequest beautyVendorRegisterRequest) throws AlreadyExistException, InvalidCredentialsException;
    ApiResponse login(BeautyVendorLoginRequest beautyVendorLoginRequest) throws DoesNotExistException, InvalidCredentialsException;



}
