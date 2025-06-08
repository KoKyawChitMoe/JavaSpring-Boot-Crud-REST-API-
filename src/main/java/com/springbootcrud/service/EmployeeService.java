package com.springbootcrud.service;

import com.springbootcrud.model.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee save(Employee employee);

    List<Employee> findAll();

    Optional<Employee> findById(int empId);

    Employee update(Employee employee);

    void deleted(int empId);

}