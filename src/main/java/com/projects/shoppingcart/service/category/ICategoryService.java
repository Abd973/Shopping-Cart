package com.projects.shoppingcart.service.category;

import com.projects.shoppingcart.model.Category;

import java.util.List;

public interface ICategoryService {
    Category addCategory(Category category);
    Category updateCategory(Long categoryId, Category category);
    Category getCategoryById(Long id);
    Category getCategoryByName(String name);
    List<Category> getAllCategories();
    void deleteCategoryById(Long id);

}
