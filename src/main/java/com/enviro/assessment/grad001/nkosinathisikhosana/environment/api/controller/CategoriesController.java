package com.enviro.assessment.grad001.nkosinathisikhosana.environment.api.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.enviro.assessment.grad001.nkosinathisikhosana.environment.api.model.Categories;
import com.enviro.assessment.grad001.nkosinathisikhosana.environment.service.CategoriesService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/categories")
public class CategoriesController {

    private final CategoriesService categoriesService;

    
    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCategoryById(@PathVariable Integer id) {
        Categories category = categoriesService.getCategoryById(id);
        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Category not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @GetMapping
    public ResponseEntity<List<Categories>> getAllCategories() {
        List<Categories> categories = categoriesService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<Categories> saveCategory(@RequestBody Categories category) {
        Categories savedCategory = categoriesService.saveCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCategory(@PathVariable Integer id, @RequestBody Categories category) {
        Categories updatedCategory = categoriesService.updateCategory(id, category);
        if (updatedCategory != null) {
            return ResponseEntity.ok(updatedCategory);
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Category not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable Integer id) {
        boolean isDeleted = categoriesService.deleteCategory(id);
        if (isDeleted) {
            Map<String, String> successResponse = new HashMap<>();
            successResponse.put("message", "Category deleted successfully");
            return ResponseEntity.ok(successResponse);
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Category not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
}