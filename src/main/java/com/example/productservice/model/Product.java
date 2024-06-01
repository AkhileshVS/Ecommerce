package com.example.productservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Product extends BaseModel {

    private String title;
    private String description;
    private double price;
    private String image;
    @ManyToOne
    private Category category;

}
