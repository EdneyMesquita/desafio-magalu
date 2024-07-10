package dev.edney.magalums.controller;

import dev.edney.magalums.dto.ScheduleNotificationDto;
import dev.edney.magalums.entity.Notification;
import dev.edney.magalums.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<Void> scheduleNotification(@RequestBody ScheduleNotificationDto dto) {
        notificationService.scheduleNotification(dto);

        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{notificationId}")
    public ResponseEntity<Notification> getNotification(@PathVariable Long notificationId) {
        var notification = notificationService.findById(notificationId);

        return notification.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{notificationId}")
    public ResponseEntity<Void> cancelNotification(@PathVariable Long notificationId) {
        notificationService.cancelNotification(notificationId);

        return ResponseEntity.noContent().build();
    }
}
