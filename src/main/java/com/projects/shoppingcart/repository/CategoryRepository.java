package com.projects.shoppingcart.repository;

import com.projects.shoppingcart.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String category);

    boolean existsByName(String name);
}
