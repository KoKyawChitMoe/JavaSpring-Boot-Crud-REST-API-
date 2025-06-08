package com.springbootcrud.controller;

import com.springbootcrud.exception.RecordNotFoundException;
import com.springbootcrud.model.Employee;
import com.springbootcrud.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private  final EmployeeService employeeService;

        @PostMapping("/create")
    public ResponseEntity<Employee> create(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.save(employee));
    }

    @GetMapping("/findById/{empId}")
    public ResponseEntity<Optional<Employee>>  findById(@PathVariable int empId){
        return ResponseEntity.ok(employeeService.findById(empId));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Employee>> findAll(){
        return ResponseEntity.ok(employeeService.findAll());
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<Employee> update(@PathVariable int empId , @RequestBody Employee employee ){
    //Custom Exception
    Employee employee1 = employeeService.findById(empId).orElseThrow(()-> new RecordNotFoundException("Employee #ID Does Not Exist"));
            employee1.setEmpName(employee.getEmpName());
            employee1.setEmail(employee.getEmail());
            employee1.setPhone(employee.getPhone());
            employee1.setEmpSalary(employee.getEmpSalary());
        return ResponseEntity.ok(employeeService.update(employee));

    }

    @DeleteMapping("/deletebyId/{empId}")
    public ResponseEntity<String> deleteById(@PathVariable  int empId){
        employeeService.findById(empId);
        return ResponseEntity.ok("Data Deleted Successfully..");

    }





}
