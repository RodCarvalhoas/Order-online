package com.order_online.order_service.domain.service;

import com.order_online.order_service.infra.JsonMapper;
import com.order_online.order_service.domain.model.OrderModel;
import com.order_online.order_service.ports.input.OrderServicePort;
import com.order_online.order_service.ports.output.MessagingServicePort;
import com.order_online.order_service.ports.output.OrderServiceRepositoryPort;

public class OrderService implements OrderServicePort {

    private OrderServiceRepositoryPort orderServiceRepositoryPort;

    private MessagingServicePort messagingServicePort;

    private JsonMapper jsonMapper;

    public OrderService(OrderServiceRepositoryPort orderServiceRepositoryPort, MessagingServicePort messagingServicePort, JsonMapper jsonMapper){
        this.orderServiceRepositoryPort = orderServiceRepositoryPort;
        this.messagingServicePort = messagingServicePort;
        this.jsonMapper = jsonMapper;
    }

    @Override
    public OrderModel createOrder(OrderModel orderModel) {
        OrderModel order = orderServiceRepositoryPort.createOrder(orderModel);

        String orderJson = jsonMapper.toJson(order);
        messagingServicePort.send(orderJson);

        return order;
    }
}
