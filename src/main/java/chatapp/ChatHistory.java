package chatapp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChatHistory implements IterableByUser {
    private List<Message> messages = new ArrayList<>();

    public void addMessage(Message msg) {
        messages.add(msg);
    }

    public Message getLastMessage() {
        if (messages.isEmpty()) return null;
        return messages.get(messages.size() - 1);
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void removeLastMessage() {
    if (!messages.isEmpty()) {
        messages.remove(messages.size() - 1);
    }
}

    @Override
    public Iterator<Message> iterator(User userToSearchWith) {
        return new SearchMessagesByUser(messages, userToSearchWith);
    }
}
