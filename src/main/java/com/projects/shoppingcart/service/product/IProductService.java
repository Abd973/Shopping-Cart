package com.projects.shoppingcart.service.product;

import com.projects.shoppingcart.model.Category;
import com.projects.shoppingcart.model.Product;
import com.projects.shoppingcart.request.ProductRequest;
import com.projects.shoppingcart.request.ProductUpdateRequest;

import java.util.List;

public interface IProductService {
    Product addProduct(ProductRequest product);
    Product updateProduct(ProductUpdateRequest product, Long productId);
    void deleteProductById(Long id);
    Product getProductById(Long id);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByCategoryAndBrand(String category, String brand);
    List<Product> getProductsByName(String name);
    List<Product> getProductsByBrandAndName(String brand, String name);
    Long countProductsByBrandAndName(String brand, String name);
}
