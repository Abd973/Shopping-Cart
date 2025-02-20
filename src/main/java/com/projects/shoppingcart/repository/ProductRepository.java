package com.projects.shoppingcart.repository;

import com.projects.shoppingcart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryName(String categoryName);
    List<Product> findByBrand(String brand);
    List<Product> findByCategoryNameAndBrand(String categoryName, String brand);
    List<Product> findByName(String productName);
    List<Product> findByBrandAndName(String brand, String name);
    Long countByBrandAndName(String brand, String name);
}
