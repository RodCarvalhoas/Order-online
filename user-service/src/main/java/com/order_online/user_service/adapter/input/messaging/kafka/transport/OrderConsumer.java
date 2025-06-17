package com.order_online.user_service.adapter.input.messaging.kafka.transport;

import java.util.List;

public record OrderConsumer(
        Long id,

        List<OrderItensConsumer> orderItens,

        Double total,

        String customerId,

        String businessId

) {
}
