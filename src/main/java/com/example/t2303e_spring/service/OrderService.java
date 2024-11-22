package com.example.t2303e_spring.service;

import com.example.t2303e_spring.entity.Order;
import com.example.t2303e_spring.entity.OrderItem;
import com.example.t2303e_spring.model.request.OrderRequest;
import com.example.t2303e_spring.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setGrandTotal(0L);
        List<OrderItem> items = orderRequest.getItems()
                .stream().map(item->{
                    OrderItem orderItem = new OrderItem();
                    orderItem.setProductId(item.getProductId());
                    orderItem.setPrice(item.getPrice());
                    orderItem.setQty(item.getQty());
                    order.setGrandTotal(order.getGrandTotal()
                                + item.getPrice() * item.getQty());
                    orderItem.setOrder(order);
                    return orderItem;
                }).toList();
        order.setItems(items);
        order.setCreatedAt(new Date());
        return orderRepository.save(order);
    }
}
