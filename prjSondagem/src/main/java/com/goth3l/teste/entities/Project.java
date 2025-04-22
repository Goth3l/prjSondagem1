package com.goth3l.teste.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Projeto")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Title;
	private List<Employee> Employee;
	
	
	public Project(Long id, String Title, List<Employee> employee) {
		super();
		this.id = id;
		this.Title = Title;
		this.Employee = employee;
	}

	public Project() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}
	
	public List<Employee> getEmployee() {
		return Employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.Employee = Employee;
	}



}