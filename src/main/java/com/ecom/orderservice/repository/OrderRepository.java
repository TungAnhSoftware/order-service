package com.ecom.orderservice.repository;

import com.ecom.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
//    Optional<OrderModel> findByName(String name);
}

