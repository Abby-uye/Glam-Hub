package com.beautyClan.glamhub.dtos.request.beautyvendorrequests;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BeautyVendorLoginRequest {
    @NotBlank(message = "Required field")
    private String email;
    @NotBlank(message = "Required field")
    private String password;
}
