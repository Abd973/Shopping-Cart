package com.projects.shoppingcart.controller;


import com.projects.shoppingcart.exceptions.AlreadyExistsException;
import com.projects.shoppingcart.exceptions.ResourceNotFoundException;
import com.projects.shoppingcart.model.Category;
import com.projects.shoppingcart.response.ApiResponse;
import com.projects.shoppingcart.service.category.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("${api.prefix}/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<ApiResponse> getAllCategories() {
        try{
            List<Category> categories = categoryService.getAllCategories();
            return ResponseEntity.ok(new ApiResponse("Found",categories));
        }catch (Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse("Error",INTERNAL_SERVER_ERROR));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addCategory(@RequestBody Category category) {
        try {
            Category addedCategory = categoryService.addCategory(category);
            return ResponseEntity.ok(new ApiResponse("Added", addedCategory));
        } catch (AlreadyExistsException e) {
            return ResponseEntity.status(CONFLICT).body(new ApiResponse(e.getMessage(), null));
        }
    }


    @GetMapping("/{category-id}")
    public ResponseEntity<ApiResponse> getCategoryById(@PathVariable("category-id") Long categoryId) {
        try {
            Category category = categoryService.getCategoryById(categoryId);
            return ResponseEntity.ok(new ApiResponse("Found", category));
        }catch (ResourceNotFoundException e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/name/{category-name}")
    public ResponseEntity<ApiResponse> getCategoryByName(@PathVariable("category-name") String categoryName) {
        try {
            Category category = categoryService.getCategoryByName(categoryName);
            return ResponseEntity.ok(new ApiResponse("Found", category));
        }catch (ResourceNotFoundException e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping("/{category-id}")
    public ResponseEntity<ApiResponse> deleteCategoryById(@PathVariable("category-id") Long categoryId) {
        try {
            categoryService.deleteCategoryById(categoryId);
            return ResponseEntity.ok(new ApiResponse("Deleted", categoryId));
        }catch (ResourceNotFoundException e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PutMapping("/{category-id}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable("category-id") Long categoryId, @RequestBody Category category) {
        try {
            Category updatedCategory = categoryService.updateCategory(categoryId, category);
            return ResponseEntity.ok(new ApiResponse("Deleted", updatedCategory));
        }catch (ResourceNotFoundException e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }






}
