package com.example.t2303e_spring.service;

import com.example.t2303e_spring.entity.Product;
import com.example.t2303e_spring.model.response.ProductResponse;
import com.example.t2303e_spring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    // reflection
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> getAll(){
        List<ProductResponse> data = new ArrayList<>();
        productRepository.findAll().
                forEach(p->data.add(ProductResponse.getProduct(p)));
        return data;
    }
}
