package com.bones.springcrud.dao;

import java.util.List;

import com.bones.springcrud.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void delete(int theId);
}
