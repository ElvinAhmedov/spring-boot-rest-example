package com.example.springrestdemo.service;

import com.example.springrestdemo.rest.model.request.EmployeeRequest;
import com.example.springrestdemo.rest.model.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponse> getAllEmployees();

    EmployeeResponse getEmployee(Long id);

    List<EmployeeResponse> getEmployeeByNameAndSurname(String name, String surname);

    void insertEmployee(EmployeeRequest employeeRequest);

    void updateEmployee(EmployeeRequest employeeRequest, Long id);

    void deleteEmployee(Long id);
}
