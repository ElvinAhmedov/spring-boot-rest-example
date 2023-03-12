package com.example.springrestdemo.rest.model.response;

import com.example.springrestdemo.rest.model.request.EmployeeRequest;

import java.util.List;

public class EmployeeResponse {
    private String name;
    private String surname;
    private Integer age;
    private Double salary;

    public String getName() {
        return name;
    }

    public EmployeeResponse setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public EmployeeResponse setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public EmployeeResponse setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Double getSalary() {
        return salary;
    }

    public EmployeeResponse setSalary(Double salary) {
        this.salary = salary;
        return this;
    }
}
