package com.springbootcrud.service;

import com.springbootcrud.model.Employee;
import com.springbootcrud.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(int empId) {
        return employeeRepository.findById(empId);
    }

    @Override
    public Employee  update(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleted(int empId) {
        employeeRepository.deleteById(empId);
    }
}
