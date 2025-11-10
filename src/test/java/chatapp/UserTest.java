package chatapp;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    ChatServer server;
    User charlie, mac;

    @BeforeEach
    void setup() {
        server = new ChatServer();
        charlie = new User("Charlie", server);
        mac = new User("Mac", server);
    }

    @Test
    void testUndoRemovesLastMessage() {
        charlie.sendMessage("Undo me", mac);
        charlie.undoLastMessage();
        assertTrue(charlie.getChatHistory().getMessages().isEmpty());
    }
}
