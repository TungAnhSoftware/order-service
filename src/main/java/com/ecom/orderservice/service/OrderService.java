package com.ecom.orderservice.service;

import com.ecom.orderservice.dto.InventoryResponse;
import com.ecom.orderservice.dto.OrderRequest;
import com.ecom.orderservice.mappers.OrderMapper;
import com.ecom.orderservice.model.Order;
import com.ecom.orderservice.model.OrderLineItems;
import com.ecom.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;
    private final WebClient webClient;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = orderMapper.ReqToModel(orderRequest);
        order.setOrderNumber(UUID.randomUUID().toString());

        List<String> skuCodes = order.getOrderLineItemsList().stream().map(OrderLineItems::getSkuCode).toList();

        //Call Inventory Service, and place order if product is in stock
        InventoryResponse[] inventoryResponseArray = webClient.get()
                .uri("http://localhost:8082/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        boolean allProductsInStock = Arrays.stream(inventoryResponseArray).allMatch(InventoryResponse::isInStock);

        //Place order
        if (allProductsInStock) {
            orderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Product is not in stock, please try again later");
        }

        log.info("Order " + order.getId() + " is added to Database!");
    }
}
