package com.ecom.orderservice.mappers;

import com.ecom.orderservice.dto.OrderItemDto;
import com.ecom.orderservice.dto.OrderReq;
import com.ecom.orderservice.model.Order;
import com.ecom.orderservice.model.OrderItem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-07T17:46:31+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order ReqToModel(OrderReq orderReq) {
        if ( orderReq == null ) {
            return null;
        }

        Order order = new Order();

        order.setOrderItemList( orderItemDtoListToOrderItemList( orderReq.getOrderItemList() ) );

        return order;
    }

    protected OrderItem orderItemDtoToOrderItem(OrderItemDto orderItemDto) {
        if ( orderItemDto == null ) {
            return null;
        }

        OrderItem orderItem = new OrderItem();

        orderItem.setId( orderItemDto.getId() );
        orderItem.setSkuCode( orderItemDto.getSkuCode() );
        orderItem.setPrice( orderItemDto.getPrice() );
        orderItem.setQuantity( orderItemDto.getQuantity() );

        return orderItem;
    }

    protected List<OrderItem> orderItemDtoListToOrderItemList(List<OrderItemDto> list) {
        if ( list == null ) {
            return null;
        }

        List<OrderItem> list1 = new ArrayList<OrderItem>( list.size() );
        for ( OrderItemDto orderItemDto : list ) {
            list1.add( orderItemDtoToOrderItem( orderItemDto ) );
        }

        return list1;
    }
}
