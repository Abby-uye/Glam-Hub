package com.beautyClan.glamhub.dtos.request.beautyvendorrequests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class BeautyVendorRegisterRequest {
   @NotBlank(message = "Required field")
    private String firstName;
    @NotBlank(message = "Required field")
    private String lastName;
    @NotBlank(message = "Required field")
    @Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+[a-zA-Z]{2,}$", message = "Please enter a valid email address.")
    private String email;
    @NotBlank(message = "Required field")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Please enter a valid password")
    private String password;
    @NotBlank(message = "Required field")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Please enter a valid password")
    private String confirmPassword;
    @NotNull(message = "Required field")
//    Date dateOfBirth;
//    @NotBlank(message = "Required field")
    private String country;
     @NotBlank(message = "Required field")
     private String state;
     @NotBlank(message = "Required field")
     private String city;
     @NotBlank(message = "Required field")
    private String street;
//    @NotBlank(message = "Required field")
//    private int postalCode;
//    @NotBlank(message = "Required field")
    private  int buildingNumber;

}
