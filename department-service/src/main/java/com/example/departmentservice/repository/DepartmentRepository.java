package com.example.departmentservice.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.departmentservice.model.Department;

@Repository
public class DepartmentRepository {

	private List<Department> departments = new ArrayList<>();

	public Department addDepartment(Department department) {
		departments.add(department);
		return department;
	}

	public Department findById(Long id) {
		return departments.stream().filter(d -> d.getId().equals(id)).findFirst().orElseThrow();
	}
	
	public List<Department> findAll(){
		return departments;
	}

}
