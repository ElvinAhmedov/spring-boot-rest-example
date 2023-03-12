package com.example.springrestdemo.exception;

import com.example.springrestdemo.enums.ErrorEnum;
import com.example.springrestdemo.rest.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomRestException.class)
    public static ResponseEntity<?> handleCustomException(CustomRestException customRestException) {
        customRestException.printStackTrace();
        return ResponseEntity.badRequest().body(customRestException.getMessage());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public static ResponseEntity<ErrorResponse> handleValidException(MethodArgumentNotValidException ex){

        return ResponseEntity.badRequest().body(ErrorResponse.of(ErrorEnum.VALIDATION_ERROR));
    }

    @ExceptionHandler(Exception.class)
    public static ResponseEntity<?> handleException(Exception exception) {
        exception.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }
}
