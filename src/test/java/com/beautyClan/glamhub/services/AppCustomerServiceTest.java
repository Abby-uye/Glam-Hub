package com.beautyClan.glamhub.services;

import com.beautyClan.glamhub.data.models.Customer;
import com.beautyClan.glamhub.data.models.Product;
import com.beautyClan.glamhub.data.repositories.CustomerRepository;
import com.beautyClan.glamhub.dtos.request.customerrequests.CustomerLoginRequest;
import com.beautyClan.glamhub.dtos.request.customerrequests.CustomerRegistrationRequest;
import com.beautyClan.glamhub.dtos.request.productrequests.AddProductToCartRequest;
import com.beautyClan.glamhub.dtos.request.productrequests.GetProductRequest;
import com.beautyClan.glamhub.dtos.request.productrequests.ProductCreationRequest;
import com.beautyClan.glamhub.exceptions.AlreadyExistException;
import com.beautyClan.glamhub.exceptions.InvalidCredentialsException;
import com.beautyClan.glamhub.utils.ApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@SpringBootTest
public class AppCustomerServiceTest {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CartService cartService;
    @Autowired ProductService productService;
    @Test
    public void testThatCanRegisterCustomer() throws AlreadyExistException {
        CustomerRegistrationRequest request = new CustomerRegistrationRequest();
        request.setFirstName("Abby");
        request.setLastName("Uye");
        request.setEmail("princessabby@gmail.com");
        request.setPassword("Passwor1*");
        ApiResponse response = customerService.register(request);
        assertNotNull(response);

    }

    @Test
    public void testThatWhenIRegisterTwoCustomerRepositoryCountIsTwo() throws AlreadyExistException {
        CustomerRegistrationRequest request = new CustomerRegistrationRequest();
        request.setFirstName("Abigail");
        request.setLastName("Uyai");
        request.setEmail("princesabby@gmail.com");
        request.setPassword("Paswor1*");
        ApiResponse response = customerService.register(request);
        assertThat(customerRepository.count()).isEqualTo(2);

    }

@Test
    public void testThatCustomerCanLogin() throws InvalidCredentialsException {
        CustomerLoginRequest request = new CustomerLoginRequest();
        request.setEmail("princesabby@gmail.com");
        request.setPassword("Paswor1*");
        ApiResponse response = customerService.login(request);
        assertNotNull(response);

}

@Test
    public void testThatCustomerCanAddToCart() {
    AddProductToCartRequest request = new AddProductToCartRequest();
    GetProductRequest productRequest = new GetProductRequest();
    productRequest.setProductSku(1L);
    Product product = productService.getProduct(productRequest);
    request.setProduct(product);
    request.setQuantity(2L);
    ApiResponse response = customerService.addToCart(request);
    assertNotNull(response);

}

}
