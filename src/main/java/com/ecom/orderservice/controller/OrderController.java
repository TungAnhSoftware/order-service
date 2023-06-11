package com.ecom.orderservice.controller;

import com.ecom.orderservice.dto.OrderReq;
import com.ecom.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/order")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    private final OrderService orderService;

    @PostMapping(path = "/placeOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderReq orderReq) {
        logger.info("Received Request createSmartPhone");
        orderService.placeOrder(orderReq);
        return "Order Placed Successfully";
    }

}
