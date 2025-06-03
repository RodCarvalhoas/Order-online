package com.order_online.user_service.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserRole {
    BUSINESS,
    CUSTOMER;

    @JsonCreator
    public static UserRole fromString(String value) {
        for (UserRole role : UserRole.values()) {
            if (role.name().equalsIgnoreCase(value)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Valor inválido para userRole: " + value +
                ". Os valores válidos são: ADMIN, CUSTOMER");
    }

    @JsonValue
    public String getValue() {
        return name();
    }
}
