package com.order_online.user_service.infra.security.config;

import com.order_online.user_service.infra.security.services.TokenService;
import com.order_online.user_service.port.output.TokenServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenConfiguration {

    @Bean
    public TokenServicePort tokenServicePort() { return new TokenService(); }
}
