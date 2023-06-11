package com.ecom.orderservice.service;

import com.ecom.orderservice.dto.OrderReq;
import com.ecom.orderservice.mappers.OrderMapper;
import com.ecom.orderservice.model.Order;
import com.ecom.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    public void placeOrder(OrderReq orderReq) {
        Order order = orderMapper.ReqToModel(orderReq);
        orderRepository.save(order);
        log.info("Order " + order.getId() + " is added to Database!");
    }
}
