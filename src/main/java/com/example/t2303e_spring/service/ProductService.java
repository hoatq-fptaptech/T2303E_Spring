package com.example.t2303e_spring.service;

import com.example.t2303e_spring.entity.Product;
import com.example.t2303e_spring.model.request.ProductRequest;
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

    public ProductResponse createProduct(ProductRequest data){
        Product product = new Product();
        product.setName(data.getName());
        product.setQty(data.getQty());
        product.setPrice(data.getPrice());
        product.setDescription(data.getDescription());
        return ProductResponse.getProduct(
                productRepository.save(product));
    }

    public ProductResponse updateProduct(Long id,ProductRequest data){
        return ProductResponse.getProduct(
                productRepository.findById(id)
                        .map(p->{
                            p.setName(data.getName());
                            p.setPrice(data.getPrice());
                            p.setQty(data.getQty());
                            p.setDescription(data.getDescription());
                            return productRepository.save(p);
                        }).orElseGet(()->{
                            Product p = new Product();
                            p.setId(id);
                            p.setName(data.getName());
                            p.setPrice(data.getPrice());
                            p.setQty(data.getQty());
                            p.setDescription(data.getDescription());
                            return productRepository.save(p);
                        })
        );
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
