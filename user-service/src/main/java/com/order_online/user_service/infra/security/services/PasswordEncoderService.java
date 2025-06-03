package com.order_online.user_service.infra.security.services;

import com.order_online.user_service.port.output.PasswordEncoderServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoderService implements PasswordEncoderServicePort {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public String encode(String password) {
        return encoder.encode(password);
    }

    @Override
    public boolean matches(String passwordTarget, String userPassword) {
        return encoder.matches(passwordTarget, userPassword);
    }
}
