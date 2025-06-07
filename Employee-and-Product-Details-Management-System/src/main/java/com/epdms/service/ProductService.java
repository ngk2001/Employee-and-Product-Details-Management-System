package com.epdms.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epdms.model.Product;
import com.epdms.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo; 


	public Product getBySerialId(String serialId) {
		return productRepo.findById(serialId).orElseThrow(()-> new RuntimeException("Product not found by "+serialId+" serial Number"));
	}

	public List<Product> getByCategory(String category){
		List<Product> products=productRepo.findAllByCategory(category);
		if(products.isEmpty()) {
			throw new RuntimeException("Any Product not found by "+category+" category");
		}
		return products;
	}
	public List<Product> getByBrand(String brand){
		List<Product> products = productRepo.findAllByBrand(brand);
		if(products.isEmpty()) {
			throw new RuntimeException("Any Product not found by "+brand+" brand");
		}
		return products;
	}
	

	public List<Product> getProductsByBranchAndDrawName(String branch, String drawName) {
		List<Product> products = productRepo.findAllByLocationBranchAndLocationDrawName(branch, drawName);
		if(products.isEmpty()) {
			throw new RuntimeException("Product not found in this location");
		}
		return products;
	}
	
	public List<Product> getAll(){
		return productRepo.findAll();
	}
	
	public List<Product> saveProduct(List<Product> product){
		return productRepo.saveAll(product);
	}
	
	public boolean deleteBySerialId(String serialId){
		if(productRepo.existsById(serialId)) {
			productRepo.deleteById(serialId);
			return true;
		}
		return false;
	}

	public Product updateProduct(Product product) {
		return productRepo.save(product);
	}
}
