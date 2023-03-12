package com.example.springrestdemo.enums;

public enum ErrorEnum {
    EMPLOYEE_NOT_FOUND(1001, "can not find employee with given id"),
    EMPLOYEES_NOT_FOUND(1002, "can not find employee with given name and surname"),
    VALIDATION_ERROR(1003,"is not valid");

    private final int code;
    private final String message;

    ErrorEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
