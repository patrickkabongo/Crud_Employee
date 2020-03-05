package com.springboot.employee.crudemployee.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employee.crudemployee.dao.EmployeeDAO;
import com.springboot.employee.crudemployee.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeDAO employeeDAO;

	// quick and dirty: inject employee dao (use constructor injection)
	@Autowired
	public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}	
	
	// expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		
		return employeeDAO.findAll();
	}
	

}
