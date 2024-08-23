package com.example.demo.service.impl;

import com.example.demo.model.entity.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(String id) {
        return categoryRepository.findById(id).orElseThrow(()->new NoSuchElementException("Khong co category nao co ma : " + id));
    }

    @Override
    public Category insertCategory(Category cate) {
        return categoryRepository.save(cate);
    }

    @Override
    public Category updateCategory(String cateId,Category cate) {
        categoryRepository.findById(cateId).orElseThrow(()->new NoSuchElementException("Khong co category nao co ma : " + cate.getCateId()));
        return categoryRepository.save(cate);
    }

    @Override
    public void deleteCategory(String id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> getCategoriesByName(String categoryName) {
        return categoryRepository.findCategoriesByCateNameContains(categoryName);
    }
}
