package com.example.springrestdemo.rest.model.request;

import javax.validation.constraints.NotBlank;

public class EmployeeRequest {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    private Integer age;
    private Double salary;

    public Long getId() {
        return id;
    }

    public EmployeeRequest setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public EmployeeRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public EmployeeRequest setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public EmployeeRequest setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Double getSalary() {
        return salary;
    }

    public EmployeeRequest setSalary(Double salary) {
        this.salary = salary;
        return this;
    }
}
