package chatapp;

import java.util.Iterator;

public class Driver {
    public static void main(String[] args) {
        ChatServer server = new ChatServer();

        User charlie = new User("Charlie", server);
        User mac = new User("Mac", server);
        User dennis = new User("Dennis", server);

        System.out.println("\n--- Messaging Demo ---");
        charlie.sendMessage("Hey Mac and Dennis!", mac, dennis);
        mac.sendMessage("What’s up Charlie?", charlie);
        dennis.sendMessage("All good here!", charlie, mac);

        System.out.println("\n--- Undo Message Demo ---");
        charlie.undoLastMessage();

        System.out.println("\n--- Blocking Demo ---");
        mac.blockUser(charlie);
        charlie.sendMessage("Mac, can you see this?", mac);
        dennis.sendMessage("I can still see you Charlie.", charlie);

        System.out.println("\n--- Iterator Demo ---");
        System.out.println("Messages involving Mac for Charlie:");
        Iterator<Message> it = charlie.getChatHistory().iterator(mac);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
