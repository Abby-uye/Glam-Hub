package com.beautyClan.glamhub.exceptions;

import com.beautyClan.glamhub.utils.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ApiResponse>invalidCredentialsException (InvalidCredentialsException invalidCredentialsException) {
        return new ResponseEntity<>(
                ApiResponse.builder()
                        .data(invalidCredentialsException.getMessage())
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .isSuccessful(false)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build(), HttpStatus.BAD_REQUEST);

}
    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ApiResponse>alreadyExistException(AlreadyExistException alreadyExistException) {
        return new ResponseEntity<>(
                ApiResponse.builder()
                        .data(alreadyExistException.getMessage())
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .isSuccessful(false)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build(), HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(DoesNotExistException.class)
    public ResponseEntity<ApiResponse>doesNotExist(DoesNotExistException doesNotExistException) {
        return new ResponseEntity<>(
                ApiResponse.builder()
                        .data(doesNotExistException.getMessage())
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .isSuccessful(false)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build(), HttpStatus.BAD_REQUEST);

    }
    }