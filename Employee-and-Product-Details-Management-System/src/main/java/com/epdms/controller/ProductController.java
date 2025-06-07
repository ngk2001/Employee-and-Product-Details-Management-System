package com.epdms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.epdms.model.Product;
import com.epdms.service.ProductService;

@RestController
@RequestMapping("/epdms/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/serialId/{serialId}")
    public ResponseEntity<?> getProductBySerialId(@PathVariable String serialId) {
    	try {
    	Product product = productService.getBySerialId(serialId);
        return ResponseEntity.ok(product);
    	}catch(RuntimeException e) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    	}
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<?> getByCategory(@PathVariable String category) {
    	try {
    	List<Product> products = productService.getByCategory(category);
        return ResponseEntity.ok(products);
    }catch(RuntimeException e) {
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    }

    @GetMapping("/brand/{brand}")
    public ResponseEntity<?> getByBrand(@PathVariable String brand) {
    	try {
        	List<Product> products = productService.getByBrand(brand);
            return ResponseEntity.ok(products);
        }catch(RuntimeException e) {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        }

    @GetMapping("/location")
    public ResponseEntity<?> getByLocation(@RequestParam String branch, @RequestParam String drawName) {
    	try {
        	List<Product> products = productService.getProductsByBranchAndDrawName(branch, drawName);
            return ResponseEntity.ok(products);
        }catch(RuntimeException e) {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        }
    
    @GetMapping("/allProducts")
    public List<Product> getAll(){
      return productService.getAll();
    }
    
    
    @PostMapping("/saveProduct")
    public ResponseEntity<List<Product>> addProducts(@RequestBody List<Product> products) {
        return ResponseEntity.ok(productService.saveProduct(products));
    }

    @DeleteMapping("delete/{serialId}")
    public ResponseEntity<String> deleteProduct(@PathVariable String serialId) {
        boolean deleted = productService.deleteBySerialId(serialId);
        return deleted ? ResponseEntity.ok("Product deleted")
                       : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
    }
    @PutMapping("/update") 
    public ResponseEntity<?> updateProduct(@RequestBody Product product){
    	return ResponseEntity.ok(productService.updateProduct(product));
    }
    
}
