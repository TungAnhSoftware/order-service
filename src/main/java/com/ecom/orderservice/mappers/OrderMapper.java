package com.ecom.orderservice.mappers;

import com.ecom.orderservice.dto.OrderRequest;
import com.ecom.orderservice.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "orderLineItemsDtoList", target = "orderLineItemsList")
    Order ReqToModel(OrderRequest orderRequest);
}
