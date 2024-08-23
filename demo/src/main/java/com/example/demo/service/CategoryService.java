package com.example.demo.service;

import com.example.demo.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    Category getCategoryById(String id);
    Category insertCategory(Category cate);
    Category updateCategory(String cateId,Category cate);
    void deleteCategory(String id);
    List<Category> getCategoriesByName(String categoryName);
}
