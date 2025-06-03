package com.order_online.user_service.infra.user;

import com.order_online.user_service.domain.service.UserService;
import com.order_online.user_service.port.output.PasswordEncoderServicePort;
import com.order_online.user_service.port.output.TokenServicePort;
import com.order_online.user_service.port.output.UserRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public UserService userService(UserRepositoryPort userRepositoryPort,
                                   PasswordEncoderServicePort passwordEncoderPort,
                                   TokenServicePort tokenServicePort) {
        return new UserService(userRepositoryPort, passwordEncoderPort, tokenServicePort);
    }
}
