package com.epdms.model;

import jakarta.persistence.*;

@Entity
public class Employee {
	@Id
	private int id;
	@Column(unique=true)
	private String username;
	private String password;
	private String branch;
	@Enumerated(EnumType.STRING)
	private Role role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Employee(int id, String username, String password, String branch, Role role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.branch = branch;
		this.role = role;
	}
	public Employee() {
		super();
	}
}
