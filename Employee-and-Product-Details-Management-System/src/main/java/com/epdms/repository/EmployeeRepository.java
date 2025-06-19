package com.epdms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epdms.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
    public List<Employee> findAllByUsername(String username);

	public Optional<Employee> findByUsername(String username);


}