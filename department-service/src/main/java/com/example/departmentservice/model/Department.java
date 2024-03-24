package com.example.departmentservice.model;

import java.util.ArrayList;
import java.util.List;

public class Department {

	public Department() {

	}

	public Department(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	private List<Employee> employees = new ArrayList<Employee>();

	private Long id;

	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [employees=" + employees + ", id=" + id + ", name=" + name + "]";
	}

}
