package org.example.controller;

import org.example.main.Category;
import org.example.repository.CategoryRepository;


import java.util.List;

public class CategoryController {
    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    

    public void createcategory(int categoryId, String type) {
        Category category = new Category(categoryId,type);
        categoryRepository.save(category);
    }


    public Category findCategoryById(int categoryId) {
        return categoryRepository.findById(categoryId);
    }

    public List<Category> viewAllCategory() {
        return categoryRepository.findAll();
    }

    public Category findCategoryByType(String type){return  categoryRepository.findByType(type);}

    public void updateCategory(int categoryId, String type) {
        Category updatedCategory = new Category(categoryId, type);
        categoryRepository.update(updatedCategory);
    }

    public void deletecategory(int categoryId) {
        categoryRepository.delete(categoryId);
    }
}