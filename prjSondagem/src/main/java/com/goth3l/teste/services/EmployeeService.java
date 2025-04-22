package com.goth3l.teste.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goth3l.teste.entities.Employee;
import com.goth3l.teste.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	private void EmployeeServices(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public Employee getEmployeeByid(Long id) {
		return employeeRepository.findById(id).orElse(null);
	}
	
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

}
