package com.beautyClan.glamhub.services;

import com.beautyClan.glamhub.data.models.Address;
import com.beautyClan.glamhub.data.models.BeautyVendor;
import com.beautyClan.glamhub.data.models.BioData;
import com.beautyClan.glamhub.data.models.Product;
import com.beautyClan.glamhub.data.repositories.BeautyVendorRepository;
import com.beautyClan.glamhub.data.repositories.ProductRepository;
import com.beautyClan.glamhub.dtos.request.beautyvendorrequests.BeautyVendorLoginRequest;
import com.beautyClan.glamhub.dtos.request.beautyvendorrequests.BeautyVendorRegisterRequest;
import com.beautyClan.glamhub.dtos.request.productrequests.GetProductRequest;
import com.beautyClan.glamhub.dtos.request.productrequests.ProductCreationRequest;
import com.beautyClan.glamhub.dtos.request.productrequests.ProductDeletionRequest;
import com.beautyClan.glamhub.exceptions.AlreadyExistException;
import com.beautyClan.glamhub.exceptions.DoesNotExistException;
import com.beautyClan.glamhub.exceptions.InvalidCredentialsException;
import com.beautyClan.glamhub.utils.ApiResponse;
import com.beautyClan.glamhub.utils.GenerateApiResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppBeautyVendorService implements BeautyVendorService, ProductService,VendorProductService {
    private final BeautyVendorRepository beautyVendorRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
//    private Validator validator;
    @Override
    public ApiResponse register(BeautyVendorRegisterRequest beautyVendorRegisterRequest) throws AlreadyExistException, InvalidCredentialsException {
        if(!IsConfirmPassword(beautyVendorRegisterRequest.getPassword(),beautyVendorRegisterRequest.getConfirmPassword()))
            throw new InvalidCredentialsException(GenerateApiResponse.INVALID_CONFIRM_PASSWORD);
        if (existingVendor(beautyVendorRegisterRequest.getEmail()))
            throw new AlreadyExistException(GenerateApiResponse.vendorAlreadyExist(beautyVendorRegisterRequest.getEmail()));
        BioData mappedBio = modelMapper.map(beautyVendorRegisterRequest, BioData.class);
        Address mappedAddress = modelMapper.map(beautyVendorRegisterRequest, Address.class);
        BeautyVendor createdVendor = modelMapper.map(beautyVendorRegisterRequest,BeautyVendor.class);
        createdVendor.setBioData(mappedBio);
        createdVendor.setAddress(mappedAddress);
        beautyVendorRepository.save(createdVendor);
        return GenerateApiResponse.created(GenerateApiResponse.WELCOME);
    }

    @Override
    public ApiResponse login(BeautyVendorLoginRequest beautyVendorLoginRequest) throws DoesNotExistException, InvalidCredentialsException {
        BeautyVendor foundVendor = beautyVendorRepository.findByBioData_EmailEquals(beautyVendorLoginRequest.getEmail());
        if(foundVendor == null) throw new DoesNotExistException(GenerateApiResponse.VENDOR_DOES_NOT_EXIST);
        if (!(foundVendor.getBioData().getPassword().equals(beautyVendorLoginRequest.getPassword())))throw new InvalidCredentialsException(GenerateApiResponse.INVALID_CREDENTIALS);
        foundVendor.setLoggedIn(true);
        return GenerateApiResponse.ok(GenerateApiResponse.LOGIN_SUCCESSFUL);
    }

    @Override
    public ApiResponse addProduct(String creatorEmail,ProductCreationRequest productCreationRequest) {
//            Product foundProduct = productRepository.findBySku()
            BeautyVendor foundVendor = findVendor(creatorEmail);
            Product newProduct = createProduct(productCreationRequest);
            foundVendor.getListOfProducts().add(newProduct);
            return GenerateApiResponse.created(GenerateApiResponse.PRODUCT_ADDED_SUCCESSFULLY);
        }

    @Override
    public ApiResponse removeProduct(String removerEmail, ProductDeletionRequest request) {
        BeautyVendor vendor =findVendor(removerEmail);
        vendor.getListOfProducts().remove(productRepository.findBySku(request.getSku()));
        productRepository.delete(productRepository.findBySku(request.getSku()));
        return GenerateApiResponse.ok(GenerateApiResponse.PRODUCT_Removed);
    }


    private boolean IsConfirmPassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    private boolean existingVendor(String email) {
       BeautyVendor vendor = findVendor(email);
        return vendor!= null;
    }


    private Product createProduct(ProductCreationRequest productCreationRequest) {
        Product newProduct = modelMapper.map(productCreationRequest, Product.class);
        productRepository.save(newProduct);
        return newProduct;
    }
    private BeautyVendor findVendor(String email){
        return beautyVendorRepository.findByBioData_EmailEquals(email);
    }

    @Override
    public Product getProduct(GetProductRequest productRequest) {
        return null;
    }
}
