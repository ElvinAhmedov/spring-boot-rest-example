package com.example.springrestdemo.exception;

import com.example.springrestdemo.enums.ErrorEnum;

public class CustomRestException extends RuntimeException{
    public CustomRestException(String message) {
        super(message);
    }
    public CustomRestException(ErrorEnum errorEnum){
        super(errorEnum.getMessage());
    }

}
