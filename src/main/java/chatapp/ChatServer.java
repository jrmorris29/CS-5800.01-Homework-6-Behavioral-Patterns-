package chatapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChatServer {
    private Map<String, User> users = new HashMap<>();

    public void registerUser(User user) {
        users.put(user.getName(), user);
    }

    public void unregisterUser(User user) {
        users.remove(user.getName());
    }

    public void sendMessage(User sender, List<User> recipients, String content) {
        Message message = new Message(sender, recipients, content);
        for (User recipient : recipients) {
            if (!recipient.isBlocked(sender)) {
                recipient.receiveMessage(message);
            }
        }
        sender.getChatHistory().addMessage(message);
    }

    public void blockUser(User blocker, User toBlock) {
        blocker.blockUser(toBlock);
    }
}
