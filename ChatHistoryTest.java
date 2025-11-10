package chatapp;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class ChatHistoryTest {
    ChatHistory history;

    @BeforeEach
    void setup() {
        history = new ChatHistory();
    }

    @Test
    void testAddAndGetLastMessage() {
        Message msg = new Message(null, List.of(), "Sample");
        history.addMessage(msg);
        assertEquals(msg, history.getLastMessage());
    }

    @Test
    void testRemoveLastMessage() {
        Message msg = new Message(null, List.of(), "To be removed");
        history.addMessage(msg);
        history.removeLastMessage();
        assertTrue(history.getMessages().isEmpty());
    }
}
