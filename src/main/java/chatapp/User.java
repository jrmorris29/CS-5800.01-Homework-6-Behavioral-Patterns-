package chatapp;

import java.util.*;

public class User {
    private String name;
    private ChatServer server;
    private ChatHistory history = new ChatHistory();
    private Set<User> blockedUsers = new HashSet<>();
    private MessageMemento lastMessageMemento;

    public User(String name, ChatServer server) {
        this.name = name;
        this.server = server;
        server.registerUser(this);
    }

    public String getName() { return name; }
    public ChatHistory getChatHistory() { return history; }

    public void sendMessage(String content, User... recipients) {
        List<User> recipientList = Arrays.asList(recipients);
        lastMessageMemento = new MessageMemento(content, java.time.LocalDateTime.now());
        server.sendMessage(this, recipientList, content);
    }

    public void receiveMessage(Message msg) {
        history.addMessage(msg);
        System.out.println(name + " received: " + msg);
    }

    public void undoLastMessage() {
        if (lastMessageMemento != null) {
            System.out.println(name + " undid message: \"" + lastMessageMemento.getContent() + "\"");
            history.removeLastMessage();
            lastMessageMemento = null;
        } else {
            System.out.println(name + " has no message to undo.");
        }
    }

    public void blockUser(User u) {
        blockedUsers.add(u);
        System.out.println(name + " blocked " + u.getName());
    }

    public boolean isBlocked(User sender) {
        return blockedUsers.contains(sender);
    }
}
