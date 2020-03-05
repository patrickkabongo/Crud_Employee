package com.springboot.employee.crudemployee.dao;

import java.util.List;

import com.springboot.employee.crudemployee.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();

}
