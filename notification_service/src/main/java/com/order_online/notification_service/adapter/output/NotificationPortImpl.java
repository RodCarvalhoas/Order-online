package com.order_online.notification_service.adapter.output;

import com.order_online.notification_service.adapter.output.strategy.EmailStrategy;
import com.order_online.notification_service.adapter.output.strategy.NotificationStrategy;
import com.order_online.notification_service.adapter.output.strategy.WhatsappStrategy;
import com.order_online.notification_service.domain.enums.NotificationChannel;
import com.order_online.notification_service.domain.model.Notification;
import com.order_online.notification_service.ports.output.NotificationPort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class NotificationPortImpl implements NotificationPort {

    private final Map<NotificationChannel, NotificationStrategy> strategyMap = new HashMap<>();

    public NotificationPortImpl(){
        strategyMap.put(NotificationChannel.EMAIL, new EmailStrategy());
        strategyMap.put(NotificationChannel.WHATSAPP, new WhatsappStrategy());
    }
    @Override
    public void sendNotification(Notification notification) {
        NotificationStrategy notificationStrategy = strategyMap.get(notification.getChannel());
        if(Objects.isNull(notificationStrategy))
            throw new IllegalArgumentException("Canal de notificação não suportado: " + notification.getChannel());

        notificationStrategy.send(notification);
    }
}
