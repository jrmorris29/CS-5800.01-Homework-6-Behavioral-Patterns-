package chatapp;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;

public class IteratorEdgeCaseTest {
    ChatServer server;
    User charlie, mac;

    @BeforeEach
    void setup() {
        server = new ChatServer();
        charlie = new User("Charlie", server);
        mac = new User("Mac", server);
    }

    @Test
    void testIteratorReturnsEmptyWhenNoMessages() {
        Iterator<Message> it = charlie.getChatHistory().iterator(mac);
        assertFalse(it.hasNext(), "Iterator should have no elements when no messages exist");
    }
}
