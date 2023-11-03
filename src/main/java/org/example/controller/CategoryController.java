package org.example.controller;

import org.example.main.Category;
import org.example.repository.CategoryRepository;

import java.util.List;

public class CategoryController {
    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void createCategory(int cat_id, String type){
        Category category = new Category(cat_id, type);
        categoryRepository.save(category);
        System.out.println("Category created: " + category.getType());
    }

    public void readCategory(int cat_id){
        Category category = categoryRepository.findById(cat_id);
        if (category != null){
            System.out.println("Category details: " + category.getCategory_id() + "," + category.getType());
        } else{
            System.out.println("Category not found.");
        }
    }

    public void updateCategory(int cat_id, String type){
        Category existingcategory = categoryRepository.findById(cat_id);
        if(existingcategory != null){
            existingcategory.setType(type);
            System.out.println("Category updated.");
        } else{
            System.out.println("Category not found.");
        }
    }

    public void deleteCategory(int cat_id){
        Category category = categoryRepository.findById(cat_id);
        if(category != null){
            categoryRepository.delete(cat_id);
            System.out.println("Category deleted: " + category.getType());
        } else {
            System.out.println("Category not found.");
        }
    }

    public void listCategories(){
        List<Category> categories = categoryRepository.findAll();
        if(!categories.isEmpty()){
            System.out.println("List of categories: ");
            for(Category category : categories){
                System.out.println("Category details: " + category.getCategory_id() + "," + category.getType());
            }
        } else {
            System.out.println("No categories found.");
        }
    }
}