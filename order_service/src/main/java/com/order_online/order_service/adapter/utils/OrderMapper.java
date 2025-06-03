package com.order_online.order_service.adapter.utils;

import com.order_online.order_service.adapter.input.transport.CreateOrderRequest;
import com.order_online.order_service.adapter.output.persistence.OrderEntity;
import com.order_online.order_service.domain.model.OrderModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { OrderItensMapper.class })
public interface OrderMapper {

    OrderModel toDomain(OrderEntity orderEntity);

    OrderEntity toEntity(OrderModel orderModel);

    @Mapping(target = "id", ignore = true)
    OrderModel requestToDomain(CreateOrderRequest orderRequest);
}
