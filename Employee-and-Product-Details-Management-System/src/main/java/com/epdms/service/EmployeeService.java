package com.epdms.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.epdms.model.Employee;
import com.epdms.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository  employeeRepo;
	
	public Employee saveEmployee(Employee employee) {
		  

	        // Save employee to DB
	        return employeeRepo.save(employee);
	    }
	
	
	public Employee getById(int id) {
		return employeeRepo.findById(id).orElseThrow(()->new RuntimeException("Employee Deatil not found"));
	}
	
	public List<Employee> getByUsername(String username) {
		List<Employee> employees = employeeRepo.findAllByUsername(username);
		if(!employees.isEmpty()) {
		return employees;
	    }
		 throw new RuntimeException("Employee not found by "+username+"name") ;
	}
	
	public List<Employee> getAll(){
		return employeeRepo.findAll();
	}
	
	public boolean deleteById(int id){
		if(employeeRepo.existsById(id)) {
			employeeRepo.deleteById(id);
			return true;
		}
		else {
			return false;
		}
	}
	
}
