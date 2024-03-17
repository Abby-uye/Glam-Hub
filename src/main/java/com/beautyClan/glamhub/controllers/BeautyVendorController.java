package com.beautyClan.glamhub.controllers;

import com.beautyClan.glamhub.dtos.request.beautyvendorrequests.BeautyVendorLoginRequest;
import com.beautyClan.glamhub.dtos.request.beautyvendorrequests.BeautyVendorRegisterRequest;
import com.beautyClan.glamhub.dtos.request.productrequests.ProductCreationRequest;
import com.beautyClan.glamhub.exceptions.AlreadyExistException;
import com.beautyClan.glamhub.exceptions.DoesNotExistException;
import com.beautyClan.glamhub.exceptions.InvalidCredentialsException;
import com.beautyClan.glamhub.services.BeautyVendorService;
import com.beautyClan.glamhub.utils.ApiResponse;
import com.beautyClan.glamhub.utils.GenerateApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/beauty_vendor")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class BeautyVendorController {
    BeautyVendorService beautyVendorService;
    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody @Valid BeautyVendorRegisterRequest beautyVendorRegisterRequest, BindingResult result) throws InvalidCredentialsException, AlreadyExistException, InvalidCredentialsException, AlreadyExistException {
        ApiResponse errorMessage = getErrorMessage(result);
        if (errorMessage!= null)
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(beautyVendorService.register(beautyVendorRegisterRequest),HttpStatus.CREATED);

    }
    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody @Valid BeautyVendorLoginRequest beautyVendorLoginRequest, BindingResult result) throws DoesNotExistException, InvalidCredentialsException {
        ApiResponse errorMessage = getErrorMessage(result);
        if(errorMessage!= null) return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(beautyVendorService.login(beautyVendorLoginRequest),HttpStatus.OK);
    }
//
//    @PostMapping("/add_product")
//    public ResponseEntity<ApiResponse> addProduct(@RequestBody @Valid ProductCreationRequest productCreationRequest, BindingResult result) throws DoesNotExistException, InvalidCredentialsException {
//        ApiResponse errorMessage = getErrorMessage(result);
//        if(errorMessage!= null) return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
//        return new ResponseEntity<>(beautyVendorService.addProduct(productCreationRequest),HttpStatus.CREATED);
//    }



    private ApiResponse getErrorMessage(BindingResult result) {
        if(result.hasErrors()){
            StringBuilder errorMessage = new StringBuilder("Validation Error(s): ");
            for(FieldError error: result.getFieldErrors()){
                errorMessage.append("Field ")
                        .append(error.getField())
                        .append("' ")
                        .append(error.getDefaultMessage())
                        .append("; ");
            }
            return GenerateApiResponse.validationError(errorMessage.toString());
        }
        return null;
    }

}


