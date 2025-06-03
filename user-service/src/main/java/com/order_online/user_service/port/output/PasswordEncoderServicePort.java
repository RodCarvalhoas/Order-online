package com.order_online.user_service.port.output;

public interface PasswordEncoderServicePort {

    String encode(String password);

    boolean matches(String passwordTarget, String userPassword);
}
