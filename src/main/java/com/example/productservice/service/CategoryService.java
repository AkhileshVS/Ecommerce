package com.example.productservice.service;

import com.example.productservice.model.Category;

import java.util.Optional;

public interface CategoryService {

    public Category save(Category category);
    public Optional<Category> findByName(String name);
}
