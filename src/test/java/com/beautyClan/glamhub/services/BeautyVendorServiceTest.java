package com.beautyClan.glamhub.services;

import com.beautyClan.glamhub.dtos.request.beautyvendorrequests.BeautyVendorLoginRequest;
import com.beautyClan.glamhub.dtos.request.beautyvendorrequests.BeautyVendorRegisterRequest;
import com.beautyClan.glamhub.exceptions.AlreadyExistException;
import com.beautyClan.glamhub.exceptions.DoesNotExistException;
import com.beautyClan.glamhub.exceptions.InvalidCredentialsException;
import com.beautyClan.glamhub.utils.ApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class BeautyVendorServiceTest {
    @Autowired
    BeautyVendorService beautyVendorService;
@Test
public void testThatCanRegister() throws InvalidCredentialsException, AlreadyExistException {
    BeautyVendorRegisterRequest request = new BeautyVendorRegisterRequest();
    request.setEmail("prinCess@mail.com");
    request.setPassword("pasQ@12");
    request.setConfirmPassword("pasQ@12");
    request.setFirstName("Abby");
    request.setLastName("uye");
    request.setCity("Surulere.");
    request.setBuildingNumber(2);
    request.setState("Lagos");
    request.setCountry("Nigeria");
    ApiResponse response = beautyVendorService.register(request);
    assertNotNull(response);
    assertNotNull(response.getData());
    assertTrue(response.isSuccessful());
//    request.setDateOfBirth("2000-03-27");

}
@Test
    public void testThatCanLogin() throws DoesNotExistException, InvalidCredentialsException {
    BeautyVendorLoginRequest request = new BeautyVendorLoginRequest();
    request.setEmail("prinCess@mail.com");
    request.setPassword("pasQ@12");
    ApiResponse response = beautyVendorService.login(request);
    assertNotNull(response);
    assertNotNull(response.getData());
    assertTrue(response.isSuccessful());

}
//    @Test
//    public void testThatVendorCanAddProduct(){
//        ProductCreationRequest request = new ProductCreationRequest();
//        request.setVendorEmail("prinCess@mail.com");
//        request.setName("rice");
//        request.setPrice(BigDecimal.valueOf(500));
//        request.setQuantity(5);
//        ApiResponse response = beautyVendorService.addProduct(request);
//        assertNotNull(response);
//        assertNotNull(response.getData());
//        assertTrue(response.isSuccessful());
//    }
//    @Test
//    public void testThatVendorCanRemoveProduct(){
//    ProductDeletionRequest request = new ProductDeletionRequest();
//    request.setSku(2L);
//    request.setVendorEmail("prinCess@mail.com");
//    ApiResponse response = beautyVendorService.removeProduct(request);
//
//    }

}
