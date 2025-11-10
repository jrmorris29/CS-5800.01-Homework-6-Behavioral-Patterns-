package chatapp;

import java.util.Iterator;
import java.util.List;

public class SearchMessagesByUser implements Iterator<Message> {
    private List<Message> messages;
    private User userToSearchWith;
    private int currentIndex = 0;

    public SearchMessagesByUser(List<Message> messages, User userToSearchWith) {
        this.messages = messages;
        this.userToSearchWith = userToSearchWith;
    }

    @Override
    public boolean hasNext() {
        while (currentIndex < messages.size()) {
            Message msg = messages.get(currentIndex);
            if (msg.getSender().equals(userToSearchWith) || msg.getRecipients().contains(userToSearchWith)) {
                return true;
            }
            currentIndex++;
        }
        return false;
    }

    @Override
    public Message next() {
        return messages.get(currentIndex++);
    }
}
