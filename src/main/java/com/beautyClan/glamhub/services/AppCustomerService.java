package com.beautyClan.glamhub.services;

import com.beautyClan.glamhub.data.models.BioData;
import com.beautyClan.glamhub.data.models.Customer;
import com.beautyClan.glamhub.data.models.Product;
import com.beautyClan.glamhub.data.repositories.CustomerRepository;
import com.beautyClan.glamhub.dtos.request.customerrequests.CustomerLoginRequest;
import com.beautyClan.glamhub.dtos.request.customerrequests.CustomerRegistrationRequest;
import com.beautyClan.glamhub.dtos.request.productrequests.AddProductToCartRequest;
import com.beautyClan.glamhub.dtos.request.productrequests.GetProductRequest;
import com.beautyClan.glamhub.exceptions.AlreadyExistException;
import com.beautyClan.glamhub.exceptions.InvalidCredentialsException;
import com.beautyClan.glamhub.utils.ApiResponse;
import com.beautyClan.glamhub.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class AppCustomerService  implements CustomerService,ProductService,CustomerProductService{
    private CustomerRepository customerRepository;
    private ModelMapper modelMapper;
    @Override
    public ApiResponse register(CustomerRegistrationRequest request) throws AlreadyExistException {
        if (isExistingCustomer(request.getEmail())) throw new AlreadyExistException(GenerateApiResponse.Customer_Already_Exist);
        BioData mappedBio = modelMapper.map(request, BioData.class);
        Customer  customer = modelMapper.map(request,Customer.class);
        customer.setBioData(mappedBio);
        customerRepository.save(customer);
        return GenerateApiResponse.created(GenerateApiResponse.CUSTOMER_CREATED_SUCCESSFULLY);
    }

    @Override
    public ApiResponse login(CustomerLoginRequest request) throws InvalidCredentialsException {
        Customer customer = findCustomer(request.getEmail());
        System.out.println(customer);
        if(IsNotExistingCustomer(customer)) throw new InvalidCredentialsException(GenerateApiResponse.INVALID_LOGIN_DETAIL);
        if(!(isCorrectPassword(request.getPassword(),customer))) throw new InvalidCredentialsException(GenerateApiResponse.INVALID_LOGIN_DETAIL);
        return GenerateApiResponse.ok(GenerateApiResponse.LOGIN_SUCCESSFUL);
    }

    @Override
    public ApiResponse addToCart(AddProductToCartRequest request) {
        return null;
    }

    private Customer findCustomer(String email){
        return customerRepository.findByBioData_EmailEquals(email);
    }
    private boolean IsNotExistingCustomer(Customer customer){
        return customer == null;
    }
    private boolean isExistingCustomer(String email){
        return customerRepository.findByBioData_EmailEquals(email)!= null;
    }
    private boolean isCorrectPassword(String password,  Customer customer){
        return Objects.equals(customer.getBioData().getPassword(), password);
    }

    @Override
    public Product getProduct(GetProductRequest productRequest) {

        return null;
    }
}
