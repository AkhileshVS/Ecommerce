package com.example.productservice.controller;

import com.example.productservice.model.Category;
import com.example.productservice.model.Product;
import com.example.productservice.service.CategoryService;
import com.example.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;
    public ProductController(ProductService productService, CategoryService categoryService){ //@qulafier is used when there are multiple service implemntations
        this.productService = productService;
        this.categoryService = categoryService;
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product){
        Category category = product.getCategory();
        Optional<Category> categoryOptional = categoryService.findByName(category.getTitle());

        if(categoryOptional.isPresent()){
           product.setCategory(categoryOptional.get());
        }
      else{
            categoryService.save(category);
        }


        return productService.createProduct(product);
    }

    @GetMapping("/id/{id}")
//    @ResponseStatus(HttpStatus.OK)
    public Product getProductById(@PathVariable("id")Long id) {
//        Product product = Product.builder().title("Harry Potter")
//                .image("Heo")
//                .category(new Category("Book"))
//                .price(100.00)
//                .description("Thisn is fiction")
//                .build();
        Product product1 = productService.getProductById(id);

        return  product1;
    }
    @GetMapping()
    public String getProductName() {

        return  "Yo";
    }

}
