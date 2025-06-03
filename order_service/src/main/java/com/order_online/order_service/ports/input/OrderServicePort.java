package com.order_online.order_service.ports.input;

import com.order_online.order_service.domain.model.OrderModel;

public interface OrderServicePort {
    OrderModel createOrder(OrderModel orderModel);

}
