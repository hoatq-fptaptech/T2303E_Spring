package com.example.t2303e_spring.repository;

import com.example.t2303e_spring.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
