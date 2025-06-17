package com.order_online.notification_service.adapter.input.kafka.transport;

public record OrderItensConsumer(
        Long id,

        String name,

        Double price
) {
}
