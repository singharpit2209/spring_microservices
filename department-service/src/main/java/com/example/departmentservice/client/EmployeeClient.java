package com.example.departmentservice.client;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import com.example.departmentservice.model.Employee;

/**
 * Declarative Client with new Spring 3 
 * @author singh
 *
 */
@HttpExchange
public interface EmployeeClient {
	
	@GetExchange("/employee/department/{departmentId}")
	public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId);

}
