package com.order_online.notification_service.adapter.input.kafka.transport;

import java.util.List;

public record OrderConsumer(
        Long id,

        List<OrderItensConsumer> orderItens,

        Double total,

        String customerId,

        String businessId

) {
}
