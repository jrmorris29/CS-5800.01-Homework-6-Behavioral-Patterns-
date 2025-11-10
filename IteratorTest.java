package chatapp;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;

public class IteratorTest {
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
    void testIteratorFindsCorrectMessages() {
        charlie.sendMessage("Hey Mac", mac);
        charlie.sendMessage("Hi Dennis", dennis);

        Iterator<Message> it = charlie.getChatHistory().iterator(mac);
        int count = 0;
        while (it.hasNext()) {
            it.next();
            count++;
        }
        assertEquals(1, count);
    }
}
