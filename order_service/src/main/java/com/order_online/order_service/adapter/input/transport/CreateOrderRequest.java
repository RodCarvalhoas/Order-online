package com.order_online.order_service.adapter.input.transport;

import jakarta.validation.constraints.*;

import java.util.List;

public record CreateOrderRequest(

        @NotNull
        List<OrderItensListRequest> orderItens,

        @NotNull
        Double total,

        @NotBlank
        String customerId,

        @NotBlank
        String businessId
) {
}
