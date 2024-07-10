package dev.edney.magalums.dto;

import dev.edney.magalums.entity.Channel;
import dev.edney.magalums.entity.Notification;
import dev.edney.magalums.entity.Status;

import java.time.LocalDateTime;

public record ScheduleNotificationDto(LocalDateTime dateTime,
                                      String destination,
                                      String message,
                                      Channel.Values channel) {
    public Notification toNotification() {
        return new Notification(
                dateTime,
                destination,
                message,
                channel.toChannel(),
                Status.Values.PENDING.toStatus()
        );
    }
}
