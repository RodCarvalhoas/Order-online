package com.order_online.order_service.adapter.input.controller;

import com.order_online.order_service.adapter.input.transport.CreateOrderRequest;
import com.order_online.order_service.adapter.utils.OrderMapper;
import com.order_online.order_service.ports.input.OrderServicePort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private OrderServicePort orderServicePort;

    @Autowired
    private OrderMapper orderMapper;

    @PostMapping
    public void createOrder(@Valid @RequestBody CreateOrderRequest createOrderRequest) {
        this.orderServicePort.createOrder(this.orderMapper.requestToDomain(createOrderRequest));
    }
}
