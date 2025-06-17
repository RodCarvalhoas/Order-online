package com.order_online.user_service.adapter.input.messaging.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.order_online.user_service.adapter.input.messaging.kafka.transport.OrderConsumer;
import com.order_online.user_service.port.input.UserServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Value("${kafka.order.pedido_criado}")
    private String TOPIC;

    @Autowired
    private UserServicePort userServicePort;

    @KafkaListener(topics = "${kafka.order.pedido_criado}", groupId = "log-group")
    public void listen(String message) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            OrderConsumer orderConsumer = objectMapper.readValue(message, OrderConsumer.class);
            userServicePort.withdrawBalance(orderConsumer.customerId(), orderConsumer.total().intValue());
        }   catch (Exception ex) {
            throw new RuntimeException("Erro ao subtrair");
        }

    }
}
