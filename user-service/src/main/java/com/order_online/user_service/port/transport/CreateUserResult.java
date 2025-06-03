package com.order_online.user_service.port.transport;

public record CreateUserResult(
        Long id,
        String tokenJWT
) {
}
