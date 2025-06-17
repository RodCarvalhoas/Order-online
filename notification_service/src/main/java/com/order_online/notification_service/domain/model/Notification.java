package com.order_online.notification_service.domain.model;

import com.order_online.notification_service.domain.enums.NotificationChannel;
public abstract class Notification {
    private String from;
    private String to;
    private String message;
    private NotificationChannel channel;

    public Notification(String from, String to, String message, NotificationChannel channel) {
        this.from = from;
        this.to = to;
        this.message = message;
        this.channel = channel;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationChannel getChannel() {
        return channel;
    }

    public void setChannel(NotificationChannel channel) {
        this.channel = channel;
    }
}
