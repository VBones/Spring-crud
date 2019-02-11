package com.bones.springcrud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bones.springcrud.entity.Employee;

//@RepositoryRestResource(path="members") если хочешь изменить путь вместо стандартного Employee(/employees)
public interface EmployeeRestRepository extends JpaRepository<Employee, Integer>{

}
