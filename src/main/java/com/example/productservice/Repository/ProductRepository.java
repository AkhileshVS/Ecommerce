package com.example.productservice.Repository;

import com.example.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
public Optional<Product> findById(Long id);
public Product save(Product product);
}
