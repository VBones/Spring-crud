package com.bones.springcrud.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bones.springcrud.dao.EmployeeDAO;
import com.bones.springcrud.entity.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	@Transactional
	public List<Employee> getEmployees() {
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee getEmployee(int theId) {
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void saveEmployee(Employee theEmployee) {
		employeeDAO.save(theEmployee);
		logger.debug("The employee was saved: " + theEmployee);
	}

	@Override
	@Transactional
	public void deleteEmployee(int theId) {
		employeeDAO.delete(theId);
		logger.debug("An employee with id " + theId + " was deleted.");
	}

}
