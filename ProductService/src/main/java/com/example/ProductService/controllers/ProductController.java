package com.example.ProductService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ProductService.services.ProductService;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @Autowired
//    public void setProductService(ProductService productService) {
//        this.productService = productService;
//    }

    @GetMapping("/{id}")
    public String getProductbyId(@PathVariable("id") Long id) {
        return productService.getProductById(id);
    }

    @GetMapping()
    public List<String> getAllProducts() {
        return Collections.emptyList();
    }
}
