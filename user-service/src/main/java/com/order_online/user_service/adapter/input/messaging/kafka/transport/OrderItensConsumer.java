package com.order_online.user_service.adapter.input.messaging.kafka.transport;

public record OrderItensConsumer(
        Long id,

        String name,

        Double price
) {
}
