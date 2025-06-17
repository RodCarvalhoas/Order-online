package com.order_online.notification_service.domain.service;

import com.order_online.notification_service.domain.enums.NotificationChannel;
import com.order_online.notification_service.domain.factory.NotificationFactory;
import com.order_online.notification_service.domain.model.Notification;
import com.order_online.notification_service.ports.input.NotificationServicePort;
import com.order_online.notification_service.ports.output.NotificationPort;

    public class NotificationService implements NotificationServicePort {

        private NotificationPort notificationPort;
        public NotificationService(NotificationPort notificationPort){
            this.notificationPort = notificationPort;
        }
        @Override
        public void sendNotification(String from, String to, String message, NotificationChannel channel) {
            Notification notification = NotificationFactory.createNotification(from, to, message, channel);
            notificationPort.sendNotification(notification);
        }
    }
