package com.example.productservice.service;

import com.example.productservice.Repository.ProductRepository;
import com.example.productservice.dto.ProductRequest;
import com.example.productservice.dto.ProductResponse;
import com.example.productservice.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    Product getProductById(Long Id);
    List<Product> getAllProducts();
    Product updateProduct(Long id, Product product);
   public  Product createProduct(Product product);
    void deleteProduct();


}
