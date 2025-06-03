package com.order_online.order_service.adapter.input.transport;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OrderItensListRequest(
        @NotBlank
        String name,

        @NotNull
        @Min(0)
        Double price
) {
}
