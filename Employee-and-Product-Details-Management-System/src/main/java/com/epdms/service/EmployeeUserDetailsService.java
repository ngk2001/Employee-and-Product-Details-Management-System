package com.epdms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.epdms.model.Employee;
import com.epdms.model.EmployeeUserDetails;
import com.epdms.repository.EmployeeRepository;
@Service
public class EmployeeUserDetailsService implements UserDetailsService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee employee = employeeRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Employee not found"));
		return new EmployeeUserDetails(employee);
	}

}
