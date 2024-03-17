package com.beautyClan.glamhub.utils;

import org.springframework.http.HttpStatus;

public class GenerateApiResponse {
    public static final String INVALID_CREDENTIALS = "Please kindly check and confirm that your credentials are correct";
    public static final String INVALID_CONFIRM_PASSWORD = "please check and confirm that your password and confirm password are the same";
    public static final String WELCOME = "Hello glam chase vendor, Welcome to the glam chase tribe";
    public static final String VENDOR_DOES_NOT_EXIST = "wrong login details";
    public static final String LOGIN_SUCCESSFUL = "Successfully logged in";
    public static final String PRODUCT_ADDED_SUCCESSFULLY = "Product added successfully";
    public static final String CUSTOMER_CREATED_SUCCESSFULLY = "Your registration was successful, Welcome to the glam hub tribe";
    public static final String INVALID_LOGIN_DETAIL = "Invalid credentials, please check that you have you are inputting the correct email and password";
    public static String PRODUCT_Removed = "Pro duct removed successfully";
    public static String Customer_Already_Exist = "A customer with this credentials already exist, please check and input your correct credentials. if you already have an account login instead";

    public static String vendorAlreadyExist(String attemptedVendorName){
        return String.format("""
            Hello %s
           A seller with this details already exist, please check and confirm that all informations are correct
           If you have an existing seller account login instead.
           You can also reach out to our support team if you need help
            
            """,attemptedVendorName);
    }
    public static ApiResponse created(String data){
        return  ApiResponse.builder()
                .data(data)
                .httpStatus(HttpStatus.CREATED)
                .statusCode(HttpStatus.CREATED.value())
                .isSuccessful(true)
                .build();
    }

    public static ApiResponse validationError(String data) {
        return
                ApiResponse.builder()
                        .data(data)
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .isSuccessful(false)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build();
    }
    public static ApiResponse ok(String data) {
        return
                ApiResponse.builder()
                        .data(data)
                        .httpStatus(HttpStatus.OK)
                        .isSuccessful(true)
                        .statusCode(HttpStatus.OK.value())
                        .build();
    }
}
