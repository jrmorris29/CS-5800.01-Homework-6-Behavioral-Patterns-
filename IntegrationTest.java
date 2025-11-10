package chatapp;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;

public class IntegrationTest {
    ChatServer server;
    User charlie, mac, dennis;

    @BeforeEach
    void setup() {
        server = new ChatServer();
        charlie = new User("Charlie", server);
        mac = new User("Mac", server);
        dennis = new User("Dennis", server);
    }

    @Test
    void testFullChatWorkflow() {
        // Step 1: Send messages (Mediator)
        charlie.sendMessage("Hey Mac!", mac);
        mac.sendMessage("Hey Charlie!", charlie);
        dennis.sendMessage("What’s up guys?", charlie, mac);

        assertEquals(1, mac.getChatHistory().getMessages().size(),
                "Mac should have received Charlie’s message");
        assertEquals(1, charlie.getChatHistory().getMessages().size(),
                "Charlie should have received Mac’s message");

        // Step 2: Undo last message (Memento)
        mac.undoLastMessage();
        assertTrue(mac.getChatHistory().getMessages().isEmpty(),
                "Mac’s last message should be undone from his history");

        // Step 3: Block user (Mediator)
        mac.blockUser(charlie);
        charlie.sendMessage("Mac, can you see this?", mac);
        assertEquals(0, mac.getChatHistory().getMessages().size(),
                "Mac should not receive messages from blocked Charlie");

        // Step 4: Iterate messages between Charlie and Mac (Iterator)
        Iterator<Message> it = charlie.getChatHistory().iterator(mac);
        int count = 0;
        while (it.hasNext()) {
            it.next();
            count++;
        }

        assertTrue(count >= 1,
                "Iterator should return at least one message involving Mac");
    }
}
