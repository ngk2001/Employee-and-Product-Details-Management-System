package com.epdms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.epdms.model.Employee;
import com.epdms.service.EmployeeService;

@RestController
@RequestMapping("/epdms/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/registerEmployee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return ResponseEntity.ok(employeeService.saveEmployee(employee));
	}
	@GetMapping("/id/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable int id){
		try {
			Employee employee = employeeService.getById(id);
			return ResponseEntity.ok(employee);
		}catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	@GetMapping("/username/{username}")
	public ResponseEntity<?> getByUsername(@PathVariable String username){
		try {
			List<Employee> employees = employeeService.getByUsername(username);
			return ResponseEntity.ok(employees);
		}catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	@GetMapping("/allEmployees")
	public List<Employee> getAllEmployees(){
		return employeeService.getAll();
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
		public ResponseEntity<String> deleteEmployee(@PathVariable int id){
		
		if(employeeService.deleteById(id)) {
			return ResponseEntity.ok("Employee detail Deleted Sucessfully");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("given id of employee did not match to anyone");
		}
	}
	@PutMapping("/modify")
	public ResponseEntity<?> modifyEmployee(@RequestBody Employee employee){
		return ResponseEntity.ok(employeeService.saveEmployee(employee));
	}
	
}
