package com.bones.springcrud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bones.springcrud.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Employee> findAll() {

		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Employee> theQuery = currentSession.createQuery("from Employee order by firstName", Employee.class);
		
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		Employee theEmployee = currentSession.find(Employee.class, theId);
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {

		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theEmployee);
	}

	@Override
	public void delete(int theId) {

		Session currentSession = entityManager.unwrap(Session.class);

		Query<Employee> theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
		
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
	}

}
