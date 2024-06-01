package com.example.productservice.service;

import com.example.productservice.model.Product;

import java.util.List;


public interface ProductService {

    Product getProductById(Long Id);
    List<Product> getAllProducts();
    Product updateProduct(Long id, Product product);
   public  Product createProduct(Product product);
    void deleteProduct();


}
