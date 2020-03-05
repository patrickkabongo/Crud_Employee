package com.springboot.employee.crudemployee.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employee.crudemployee.entity.Employee;
import com.springboot.employee.crudemployee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;

	// quick and dirty: inject employee dao (use constructor injection)
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}	
	
	// add mapping for GET/customers to list all employees
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		
		return employeeService.findAll();
	}
	
	// add mapping for GET /employees/{employeeId} to get a single employee
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee theEmployee = employeeService.findById(employeeId);
		
		if(theEmployee == null) {
			throw new EmployeeNotFoundException("Employee id not found - " + employeeId);		
		}
		
		return theEmployee;
	}
	
	// add mapping for POST/employees - add new employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		
		employeeService.save(theEmployee);	
		
		return theEmployee;
	}
	
	// add mapping for PUT/employees - update existing employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		employeeService.save(theEmployee);	
		
		return theEmployee;
	}
	
	// add mapping for DELETE/employees - delete existing employee
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee theEmployee = employeeService.findById(employeeId);
		
		if(theEmployee == null) {
			throw new EmployeeNotFoundException("Employee id not found - " + employeeId);		
		}
		
		employeeService.deleteById(employeeId);
		
		return "Deleted employee id - " + employeeId;
	}
	

}
