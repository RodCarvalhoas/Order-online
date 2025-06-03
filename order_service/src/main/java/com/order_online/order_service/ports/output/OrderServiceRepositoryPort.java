package com.order_online.order_service.ports.output;

import com.order_online.order_service.domain.model.OrderModel;

public interface OrderServiceRepositoryPort {

    OrderModel createOrder(OrderModel orderModel);
}
