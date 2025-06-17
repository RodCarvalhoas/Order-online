package com.order_online.notification_service.ports.input;

import com.order_online.notification_service.domain.enums.NotificationChannel;

public interface NotificationServicePort {

    void sendNotification(String from, String to, String message, NotificationChannel channel);
}
