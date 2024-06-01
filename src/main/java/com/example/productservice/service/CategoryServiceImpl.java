package com.example.productservice.service;

import com.example.productservice.Repository.CategoryRepository;
import com.example.productservice.model.Category;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CategoryServiceImpl implements CategoryService{
    public final CategoryRepository categoryRepository;
    CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }


    @Override
    public Category save(Category category) {
        categoryRepository.save(category);
        return category;
    }

    @Override
    public Optional<Category> findByName(String name) {

        return categoryRepository.findByTitle(name);
    }
}
