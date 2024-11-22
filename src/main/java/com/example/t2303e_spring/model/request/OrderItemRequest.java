package com.example.t2303e_spring.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemRequest {
    private Long productId;
    private Long price;
    private Long qty;
}
