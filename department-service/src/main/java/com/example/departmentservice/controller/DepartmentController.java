package com.example.departmentservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.departmentservice.client.EmployeeClient;
import com.example.departmentservice.model.Department;
import com.example.departmentservice.repository.DepartmentRepository;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private EmployeeClient employeeClient;

	@PostMapping
	public Department add(@RequestBody Department department) {
		LOGGER.info("Department to add {}", department);
		return departmentRepository.addDepartment(department);
	}

	@GetMapping
	public List<Department> findAll() {
		LOGGER.info("Department Find All Called");
		return departmentRepository.findAll();
	}

	@GetMapping("/{id}")
	public Department findById(@PathVariable Long id) {
		LOGGER.info("Department Find by Id {}", id);
		return departmentRepository.findById(id);
	}

	@GetMapping("/with-employees")
	public List<Department> findAllWithEmployees() {
		LOGGER.info("Find Department with Employees");
		List<Department> departments = departmentRepository.findAll();
		departments.forEach(d -> d.setEmployees(employeeClient.findByDepartment(d.getId())));
		return departments;

	}

}
