package com.example.productservice.controller;

import com.example.productservice.Commns.AuthenticationCommons;
import com.example.productservice.dto.Roles;
import com.example.productservice.dto.UserDto;
import com.example.productservice.model.Category;
import com.example.productservice.model.Product;
import com.example.productservice.service.CategoryService;
import com.example.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;
    private final AuthenticationCommons authenticationCommons;
    public ProductController(ProductService productService, CategoryService categoryService,AuthenticationCommons authenticationCommons){ //@qulafier is used when there are multiple service implemntations
        this.productService = productService;
        this.categoryService = categoryService;
        this.authenticationCommons =authenticationCommons;
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
    public ResponseEntity<Product> getProductById(@PathVariable("id")Long id,@RequestHeader("AuthenticationToken") String token) {
//        Product product = Product.builder().title("Harry Potter")
//                .image("Heo")
//                .category(new Category("Book"))
//                .price(100.00)
//                .description("Thisn is fiction")
//                .build();
        UserDto userDto1 = authenticationCommons.validateToken(token);
        if(userDto1 ==null){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        boolean isAdmin = false;
        for(Roles role:userDto1.getRoles()){
            if(role.getName().equals("ADMIN")){
                isAdmin = true;
                break;
            }
        }
        if(!isAdmin){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        Product product1 = productService.getProductById(id);

        return  new ResponseEntity<>(product1,HttpStatus.OK);
    }
    @GetMapping()
    public String getProductName() {

        return  "Yo";
    }

}
