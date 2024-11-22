package com.example.t2303e_spring.controller;

import com.example.t2303e_spring.entity.Order;
import com.example.t2303e_spring.model.request.OrderRequest;
import com.example.t2303e_spring.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/create-order")
public class CheckoutController {
    private final OrderService orderService;

    public CheckoutController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping()
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest request){
        Order order = orderService.createOrder(request);
        return ResponseEntity.ok(order);
    }

}
