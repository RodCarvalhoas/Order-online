package com.order_online.notification_service.domain.model;

import com.order_online.notification_service.domain.enums.NotificationChannel;

public class WhatsappNotification extends Notification {

    public WhatsappNotification(String from, String to, String message) {
        super(from, to, message, NotificationChannel.WHATSAPP);
    }
}
