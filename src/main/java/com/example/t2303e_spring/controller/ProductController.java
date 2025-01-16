package com.example.t2303e_spring.controller;

import com.example.t2303e_spring.model.request.ProductRequest;
import com.example.t2303e_spring.model.response.ProductResponse;
import com.example.t2303e_spring.service.ProductService;
import com.example.t2303e_spring.service.RabbitMQProducer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private ProductService productService;
    private final RabbitMQProducer producer;
    public ProductController(ProductService productService, RabbitMQProducer producer) {
        this.productService = productService;
        this.producer = producer;
    }

    @GetMapping()
    public List<ProductResponse> getAllProduct(){
        producer.sendMessage("Đơn hàng đã được đặt");
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

    @GetMapping("/search")
    public List<ProductResponse> search(@RequestParam String search){
        return productService.search(search);
    }

    @GetMapping("/filter")
    public List<ProductResponse> filter(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer minPrice,
            @RequestParam(required = false) Integer maxPrice
    ){
        return productService.filter(name,minPrice,maxPrice);
    }
}
