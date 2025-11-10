package chatapp;

import java.time.LocalDateTime;
import java.util.List;

public class Message {
    private User sender;
    private List<User> recipients;
    private String content;
    private LocalDateTime timestamp;

    public Message(User sender, List<User> recipients, String content) {
        this.sender = sender;
        this.recipients = recipients;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    public User getSender() { return sender; }
    public List<User> getRecipients() { return recipients; }
    public String getContent() { return content; }
    public LocalDateTime getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + sender.getName() + ": " + content;
    }
}
