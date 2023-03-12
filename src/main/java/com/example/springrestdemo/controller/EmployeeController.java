package com.example.springrestdemo.controller;

import com.example.springrestdemo.rest.model.request.EmployeeRequest;
import com.example.springrestdemo.rest.model.response.EmployeeResponse;
import com.example.springrestdemo.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employees")
@Tag(name = "Employee services",description = "employee services")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    @Operation(summary = "This endpoint gets all employees ")
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable Long id) {
        return ResponseEntity.ok().body(employeeService.getEmployee(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<EmployeeResponse>> getEmployeeByNameAndSurname(@RequestParam("name") String name,
                                                                             @RequestParam("surname") String surname) {

        return ResponseEntity.ok().body(employeeService.getEmployeeByNameAndSurname(name, surname));
    }
    @PostMapping("/insert")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertEmployee (@Valid @RequestBody EmployeeRequest employeeRequest){
         employeeService.insertEmployee(employeeRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateEmployee( @Valid @RequestBody EmployeeRequest employeeRequest, @PathVariable Long id){
        employeeService.updateEmployee(employeeRequest,id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }
}
