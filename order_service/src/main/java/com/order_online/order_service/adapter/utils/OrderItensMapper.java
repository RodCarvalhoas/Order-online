package com.order_online.order_service.adapter.utils;

import com.order_online.order_service.adapter.input.transport.OrderItensListRequest;
import com.order_online.order_service.adapter.output.persistence.OrderItensEntity;
import com.order_online.order_service.domain.model.OrderItensModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderItensMapper {
    OrderItensModel toModel(OrderItensEntity entity);
    OrderItensEntity toEntity(OrderItensModel model);

    @Mapping(target = "id", ignore = true)
    OrderItensModel requestToModel(OrderItensListRequest orderItensListRequest);
}
