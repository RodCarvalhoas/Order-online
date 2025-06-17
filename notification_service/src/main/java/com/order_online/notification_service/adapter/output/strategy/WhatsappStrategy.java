package com.order_online.notification_service.adapter.output.strategy;

import com.order_online.notification_service.domain.model.Notification;

public class WhatsappStrategy implements NotificationStrategy {
    @Override
    public void send(Notification notification) {
        System.out.println("Mensagem enviada com sucesso! -> " + notification.getMessage());
    }
}
