package com.order_online.order_service.infra;

import com.order_online.order_service.adapter.output.messaging.kafka.KafkaProducer;
import com.order_online.order_service.adapter.output.repository.OrderEntityRepository;
import com.order_online.order_service.domain.service.OrderService;
import com.order_online.order_service.ports.input.OrderServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfig {

    @Autowired
    OrderEntityRepository orderEntityRepository;

    @Autowired
    KafkaProducer kafkaProducer;

    @Autowired
    JsonMapper jsonMapper;

    @Bean
    OrderServicePort orderServicePort(){
        return new OrderService(orderEntityRepository, kafkaProducer, jsonMapper);
    }
}
