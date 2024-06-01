package com.example.productservice.Repository;

import com.example.productservice.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    public Category save(Category category);
    public Optional<Category> findByTitle(String title);
}
