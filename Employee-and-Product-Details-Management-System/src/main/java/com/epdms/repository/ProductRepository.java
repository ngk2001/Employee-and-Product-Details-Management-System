package com.epdms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epdms.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

	public List<Product> findAllByCategory(String category);

	public List<Product> findAllByLocationBranchAndLocationDrawName(String branch, String drawName);

	public List<Product> findAllByBrand(String brand);

}
