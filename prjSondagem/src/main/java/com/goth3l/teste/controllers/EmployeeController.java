package com.goth3l.teste.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goth3l.teste.entities.Employee;
import com.goth3l.teste.services.EmployeeService;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeByid(id);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Employee>> findAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployee();
        return ResponseEntity.ok(employees);
    }

    @PostMapping
    public ResponseEntity<Employee> insertEmployee( @RequestBody Employee employee) {
        Employee newEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEmployee);
    }
}