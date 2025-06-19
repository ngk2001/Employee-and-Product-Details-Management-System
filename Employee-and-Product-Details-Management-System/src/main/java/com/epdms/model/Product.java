package com.epdms.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Product {
	@Id
	private String serialId;
    private String name;
    private String brand;
    private String category;
    private String count;
    private double price;
    @Embedded
    private Location location;

	public String getSerialId() {
		return serialId;
	}
	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Product(Long id, String serialId, String name, String brand, String category, String count, double price,
			Location location) {
		super();
		this.serialId = serialId;
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.count = count;
		this.price = price;
		this.location = location;
	}
	public Product() {
		super();
	}

}
