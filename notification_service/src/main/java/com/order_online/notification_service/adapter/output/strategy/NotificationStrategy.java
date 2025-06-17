package com.order_online.notification_service.adapter.output.strategy;

import com.order_online.notification_service.domain.model.Notification;

public interface NotificationStrategy {
    void send(Notification notification);
}