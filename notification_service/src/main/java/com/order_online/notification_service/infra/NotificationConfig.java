package com.order_online.notification_service.infra;

import com.order_online.notification_service.domain.factory.NotificationFactory;
import com.order_online.notification_service.domain.service.NotificationService;
import com.order_online.notification_service.ports.input.NotificationServicePort;
import com.order_online.notification_service.ports.output.NotificationPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    @Bean
    NotificationFactory notificationFactory(){
        return new NotificationFactory();
    }

    @Bean
    NotificationServicePort notificationServicePort(NotificationPort notificationPort){
        return new NotificationService(notificationPort);
    }


}
