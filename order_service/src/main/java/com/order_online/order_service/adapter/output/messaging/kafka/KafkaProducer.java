package com.order_online.order_service.adapter.output.messaging.kafka;

import com.order_online.order_service.ports.output.MessagingServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer implements MessagingServicePort {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.order.pedido_criado}")
    private String TOPIC;

    @Override
    public void send(String message) {
        kafkaTemplate.send(TOPIC, message);
    }
}
