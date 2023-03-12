package com.example.springrestdemo.rest.model.response;

import com.example.springrestdemo.enums.ErrorEnum;

public class ErrorResponse {
   private int code;
   private String message;


    public int getCode() {
        return code;
    }

    public ErrorResponse setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ErrorResponse setMessage(String message) {
        this.message = message;
        return this;
    }
    public static  ErrorResponse of(ErrorEnum errorEnum){
        return new ErrorResponse().setCode(errorEnum.getCode())
                .setMessage(errorEnum.getMessage());
    }

}
