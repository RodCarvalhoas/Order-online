package com.order_online.notification_service.domain.factory;

import com.order_online.notification_service.domain.enums.NotificationChannel;
import com.order_online.notification_service.domain.model.EmailNotification;
import com.order_online.notification_service.domain.model.Notification;
import com.order_online.notification_service.domain.model.WhatsappNotification;

public class NotificationFactory {
   public static Notification createNotification(String from, String to, String message, NotificationChannel channel) {
       return switch (channel) {
           case EMAIL -> new EmailNotification(from, to, message);
           case WHATSAPP -> new WhatsappNotification(from, to, message);
           default -> throw new IllegalArgumentException("Unsupported notification channel: " + channel);
       };
   }

}
