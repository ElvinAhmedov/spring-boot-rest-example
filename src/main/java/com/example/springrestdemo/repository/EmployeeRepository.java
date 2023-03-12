package com.example.springrestdemo.repository;

import com.example.springrestdemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    List<Employee> findByNameAndSurname(String name, String surname);
    Optional<Employee> findByName(String name);
}
