package com.order_online.notification_service.ports.output;

import com.order_online.notification_service.domain.model.Notification;

public interface NotificationPort {

    void sendNotification(Notification notification);
}
