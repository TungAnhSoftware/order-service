package com.ecom.orderservice.service;

import com.ecom.orderservice.dto.OrderRequest;
import com.ecom.orderservice.mappers.OrderMapper;
import com.ecom.orderservice.model.Order;
import com.ecom.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = orderMapper.ReqToModel(orderRequest);
        order.setOrderNumber(UUID.randomUUID().toString());
        orderRepository.save(order);
        log.info("Order " + order.getId() + " is added to Database!");
    }
}
