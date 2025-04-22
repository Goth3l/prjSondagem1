package com.goth3l.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goth3l.teste.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

