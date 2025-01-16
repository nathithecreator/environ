package com.enviro.assessment.grad001.nkosinathisikhosana.environment.service;

import org.springframework.stereotype.Service;
import com.enviro.assessment.grad001.nkosinathisikhosana.environment.api.model.Categories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriesService {

    private List<Categories> categoriesList;

    public CategoriesService() {
        categoriesList = new ArrayList<>();
        // Sample data for demonstration purposes
        categoriesList.add(new Categories(1, "Category 1", "Description for Category 1"));
        categoriesList.add(new Categories(2, "Category 2", "Description for Category 2"));
    }

    public Categories getCategoryById(Integer id) {
        return categoriesList.stream()
                .filter(category -> category.getId().equals(id.longValue()))
                .findFirst()
                .orElse(null);
    }

    public List<Categories> getAllCategories() {
        return new ArrayList<>(categoriesList);
    }

    public Categories saveCategory(Categories category) {
        categoriesList.add(category);
        return category;
    }

    public Categories updateCategory(Integer id, Categories updatedCategory) {
        Optional<Categories> existingCategoryOpt = categoriesList.stream()
                .filter(category -> category.getId().equals(id.longValue()))
                .findFirst();

        if (existingCategoryOpt.isPresent()) {
            Categories existingCategory = existingCategoryOpt.get();
            existingCategory.setName(updatedCategory.getName());
            existingCategory.setDescription(updatedCategory.getDescription());
            return existingCategory;
        } else {
            return null;
        }
    }

    public boolean deleteCategory(Integer id) {
        return categoriesList.removeIf(category -> category.getId().equals(id.longValue()));
    }
}
