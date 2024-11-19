package com.example.t2303e_spring.controller;

import com.example.t2303e_spring.model.request.ProductRequest;
import com.example.t2303e_spring.model.response.ProductResponse;
import com.example.t2303e_spring.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<ProductResponse> getAllProduct(){
        return productService.getAll();
    }

    @PostMapping()
    public ProductResponse createProduct(@RequestBody ProductRequest req){
        return productService.createProduct(req);
    }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable Long id, @RequestBody ProductRequest req){
        return productService.updateProduct(id,req);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }
}
