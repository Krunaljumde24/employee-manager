/**
 * 
 */
package com.hacker.employeemanager.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hacker.employeemanager.constants.StringConstants;
import com.hacker.employeemanager.model.Employee;
import com.hacker.employeemanager.service.EmployeeService;

/**
 * @author Krunal
 *
 */
@RestController
@RequestMapping(StringConstants.EMPLOYEE)
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping(StringConstants.ALL)
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> employees = employeeService.findAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@GetMapping(StringConstants.FIND_ID)
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
		Employee employee = employeeService.findEmployeeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@PostMapping(StringConstants.ADD)
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee e) {
		Employee employee = employeeService.addEmployee(e);
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@PutMapping(StringConstants.UPDATE)
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee updtEmployee = employeeService.updateEmployee(employee);
		return new ResponseEntity<Employee>(updtEmployee, HttpStatus.OK);
	}

	@DeleteMapping(StringConstants.DELETE)
	public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id) {
		return new ResponseEntity<String>(employeeService.deleteEmployee(id), HttpStatus.OK);

	}

}
