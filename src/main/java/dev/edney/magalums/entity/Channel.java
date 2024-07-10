package dev.edney.magalums.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "channels")
public class Channel {
    public Channel() {
    }

    public Channel(long channelId, String description) {
        this.channelId = channelId;
        this.description = description;
    }

    @Id
    private long channelId;

    private String description;

    public long getChannelId() {
        return channelId;
    }

    public void setChannelId(long channelId) {
        this.channelId = channelId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public enum Values {
        EMAIL(1L, "email"),
        SMS(2L, "sms"),
        PUSH(3L, "push"),
        WHATSAPP(4L, "whatsapp");

        private Long id;
        private String description;

        Values(Long id, String description) {
            this.id = id;
            this.description = description;
        }

        public Channel toChannel() {
            return new Channel(id, description);
        }
    }
}
