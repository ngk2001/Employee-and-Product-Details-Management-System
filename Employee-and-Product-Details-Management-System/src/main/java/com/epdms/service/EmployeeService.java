package com.epdms.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.epdms.model.Employee;
import com.epdms.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository  employeeRepo;
	
    @Autowired
    private PasswordEncoder encoder;

	public Employee saveEmployee(Employee employee) {

		  employee.setPassword(encoder.encode(employee.getPassword()));
	        return employeeRepo.save(employee);
	    }

	public String verifyEmployee(Employee employee) {
		return "fail";

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
