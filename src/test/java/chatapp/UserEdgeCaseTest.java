package chatapp;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserEdgeCaseTest {
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
    void testUndoWhenNoMessageExists() {
        // should not throw or crash when undoing with no previous message
        mac.undoLastMessage();
        assertTrue(mac.getChatHistory().getMessages().isEmpty(),
                "Chat history should remain empty after undo with no message");
    }

    @Test
    void testSendMessageToMultipleRecipients() {
        charlie.sendMessage("Hey everyone!", mac, dennis);

        assertEquals(1, mac.getChatHistory().getMessages().size(),
                "Mac should receive one message");
        assertEquals(1, dennis.getChatHistory().getMessages().size(),
                "Dennis should receive one message");
    }
}
