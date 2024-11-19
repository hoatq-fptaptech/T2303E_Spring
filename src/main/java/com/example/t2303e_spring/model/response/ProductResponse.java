package com.example.t2303e_spring.model.response;

import com.example.t2303e_spring.entity.Product;
import lombok.Getter;

@Getter
public class ProductResponse {
    private ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.inStock = product.getQty() > 0;
        this.description = product.getDescription();
    }

    private Long id;
    private String name;
    private Long price;
    private Boolean inStock;
    private String description;

    public static ProductResponse getProduct(Product product){
        return new ProductResponse(product);
    }
}
