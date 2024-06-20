package com.example.productservice.dto;

import com.example.productservice.model.BaseModel;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
public class Roles extends BaseModel {
    private String name;
}

