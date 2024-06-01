package com.example.productservice.controller;

import com.example.productservice.Repository.CategoryRepository;
import com.example.productservice.model.Category;
import com.example.productservice.service.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;
    CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @GetMapping()
    public String get(){
        return "Hello";
    }

    @PostMapping
    public String save(@RequestBody Category category){
        categoryService.save(category);
        return "Saved Category!";
    }

}
