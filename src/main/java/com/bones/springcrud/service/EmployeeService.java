package com.bones.springcrud.service;

import java.util.List;

import com.bones.springcrud.entity.Employee;


public interface EmployeeService {

	public List<Employee> getEmployees();
	
	public Employee getEmployee(int theId);
	
	public void saveEmployee(Employee theEmployee);
	
	public void deleteEmployee(int theId);
}
