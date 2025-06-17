package com.order_online.notification_service.adapter.input.kafka;

import com.order_online.notification_service.adapter.input.kafka.transport.OrderConsumer;
import com.order_online.notification_service.domain.model.EmailNotification;
import com.order_online.notification_service.domain.model.WhatsappNotification;
import com.order_online.notification_service.ports.output.NotificationPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class KafkaConsumer {

    @Value("${kafka.order.pedido_criado}")
    private String TOPIC;

    @Autowired
    private NotificationPort notificationPort;

    @KafkaListener(topics = "${kafka.order.pedido_criado}", groupId = "log-group")
    public void listen(String message) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            OrderConsumer orderConsumer = objectMapper.readValue(message, OrderConsumer.class); //TODO -> Deveriamos recuperar o valor do contato do usuario(Email, Whatsapp)...
            notificationPort.sendNotification(new WhatsappNotification("teste@teste.com.br", "to@teste.com.br", "Olá POC - KAFKA"));
        }   catch (Exception ex) {
            throw new RuntimeException("Erro ao enviar a notificação");
        }

    }
}
