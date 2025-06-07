package com.epdms.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Location {
	private String branch;
	private String drawName;
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getDrawName() {
		return drawName;
	}
	public void setDrawName(String drawName) {
		this.drawName = drawName;
	}
	public Location(String branch, String drawName) {
		super();
		this.branch = branch;
		this.drawName = drawName;
	}
	public Location() {
		super();
	}
	
	

}
