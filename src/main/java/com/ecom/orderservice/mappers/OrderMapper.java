package com.ecom.orderservice.mappers;

import com.ecom.orderservice.dto.OrderReq;
import com.ecom.orderservice.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "orderItemList")
    Order ReqToModel(OrderReq orderReq);
}
