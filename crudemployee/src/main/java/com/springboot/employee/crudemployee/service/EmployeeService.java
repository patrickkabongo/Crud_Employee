package com.springboot.employee.crudemployee.service;

import java.util.List;

import com.springboot.employee.crudemployee.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	public Employee findById(int theId);
	public void save(Employee theEmployee);
	public void deleteById(int theId);
}
