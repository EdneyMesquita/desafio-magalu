package dev.edney.magalums.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "status")
public class Status {
    public Status() {
    }

    public Status(long statusId, String description) {
        this.statusId = statusId;
        this.description = description;
    }

    @Id
    private long statusId;

    private String description;

    public long getStatusId() {
        return statusId;
    }

    public void setStatusId(long statusId) {
        this.statusId = statusId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public enum Values {
        PENDING(1L, "pending"),
        SUCCESS(2L, "success"),
        ERROR(3L, "error"),
        CANCELLED(4L, "cancelled");

        private Long id;
        private String description;

        Values(Long id, String description) {
            this.id = id;
            this.description = description;
        }

        public Status toStatus() {
            return new Status(id, description);
        }
    }
}
