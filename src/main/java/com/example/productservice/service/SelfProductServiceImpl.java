package com.example.productservice.service;

import com.example.productservice.Repository.CategoryRepository;
import com.example.productservice.Repository.ProductRepository;
import com.example.productservice.model.Category;
import com.example.productservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SelfProductService")
public class SelfProductServiceImpl implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    SelfProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }
    @Override
    public Product getProductById(Long Id) {

        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct() {

    }
}
