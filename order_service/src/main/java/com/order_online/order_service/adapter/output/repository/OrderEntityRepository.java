package com.order_online.order_service.adapter.output.repository;

import com.order_online.order_service.adapter.output.persistence.OrderEntity;
import com.order_online.order_service.adapter.utils.OrderMapper;
import com.order_online.order_service.domain.model.OrderModel;
import com.order_online.order_service.ports.output.OrderServiceRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OrderEntityRepository implements OrderServiceRepositoryPort {

    @Autowired
    private OrderEntityRepositoryJpa orderEntityRepositoryJpa;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    @Transactional
    public OrderModel createOrder(OrderModel orderModel) {
        OrderEntity orderEntity = orderEntityRepositoryJpa.save(orderMapper.toEntity(orderModel));
        return orderMapper.toDomain(orderEntity);
    }
}
