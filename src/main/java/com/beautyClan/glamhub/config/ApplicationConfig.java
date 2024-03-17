package com.beautyClan.glamhub.config;

import jakarta.validation.Validator;
import org.hibernate.validator.internal.engine.ValidatorImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

//    @Bean
//    public Validator validator(){
//    }
}
