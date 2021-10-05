/**
 * 
 */
package com.hacker.employeemanager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hacker.employeemanager.model.Employee;

/**
 * @author Krunal
 *
 */
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	public String deleteEmployeeById(Long id);

	Optional<Employee> findEmployeeById(Long id);
	
}
