package chatapp;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChatServerTest {
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
    void testSendMessage() {
        charlie.sendMessage("Test message", mac);
        assertEquals(1, mac.getChatHistory().getMessages().size());
    }

    @Test
    void testBlockUser() {
        mac.blockUser(charlie);
        charlie.sendMessage("Blocked?", mac);
        assertEquals(0, mac.getChatHistory().getMessages().size());
    }
}
