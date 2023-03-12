package com.example.springrestdemo.service.impl;

import com.example.springrestdemo.enums.ErrorEnum;
import com.example.springrestdemo.exception.CustomRestException;
import com.example.springrestdemo.model.Employee;
import com.example.springrestdemo.repository.EmployeeRepository;
import com.example.springrestdemo.rest.model.request.EmployeeRequest;
import com.example.springrestdemo.rest.model.response.EmployeeResponse;
import com.example.springrestdemo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponse> employeeResponse = employees.stream()
                .map(employee -> convertEmployeeToResponse(employee))
                .collect(Collectors.toList());
        return employeeResponse;
    }

    @Override
    public EmployeeResponse getEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new CustomRestException(ErrorEnum.EMPLOYEE_NOT_FOUND));
        EmployeeResponse employeeResponse = convertEmployeeToResponse(employee);
        return employeeResponse;
    }

    @Override
    public List<EmployeeResponse> getEmployeeByNameAndSurname(String name, String surname) {


        List<Employee> employees = employeeRepository.findByNameAndSurname(name, surname);
        if (employees.isEmpty()) {
            throw new CustomRestException(ErrorEnum.EMPLOYEES_NOT_FOUND);
        }

        List<EmployeeResponse> employeeResponseList = employees.stream()
                .map(employee -> convertEmployeeToResponse(employee))
                .collect(Collectors.toList());
        return employeeResponseList;
    }

    @Override
    public void insertEmployee(EmployeeRequest employeeRequest) {
        Employee employee = convertRequestToEmployee(employeeRequest);
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(EmployeeRequest employeeRequest, Long id) {
        Employee employee = getEmployeeById(id);
        employee.setAge(employeeRequest.getAge())
                .setSalary(employeeRequest.getSalary())
                .setSurname(employeeRequest.getSurname())
                .setName(employeeRequest.getName());
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id);
        employeeRepository.delete(employee);
    }

    private Employee convertRequestToEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee();
        employee.setAge(employeeRequest.getAge())
                .setName(employeeRequest.getName())
                .setSurname(employeeRequest.getSurname())
                .setSalary(employeeRequest.getSalary());
        return employee;
    }

    private EmployeeResponse convertEmployeeToResponse(Employee employee) {
        return new EmployeeResponse()
                .setName(employee.getName())
                .setSurname(employee.getSurname())
                .setAge(employee.getAge())
                .setSalary(employee.getSalary());
    }

    private Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow
                (() -> new CustomRestException(ErrorEnum.EMPLOYEE_NOT_FOUND));
    }

}
