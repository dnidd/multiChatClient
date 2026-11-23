import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Connects to server via Socket.
 * Create communication Thread.
 * Take user input - send to Handler.
 * Take message coming from server.
 * Chat can read from the keyboard while ChatSocketHandler is listening to the server.
 */
public class Chat {

    private Socket socket;
    private ChatSocketHandler chatSocketHandler;

    /**
     * Constructor
     * @param host = server address/host
     * @param port = port
     */
    public Chat(String host, int port) throws IOException {
        // Connect socket to server
        socket = new  Socket(host, port);
//        System.out.println("Connected to " + host + ":" + port);

    }

    /**
     * Create chatSocketHandler
     * Create and start Thread with chatSocketHandler injected.
     * Take incoming messages from keyboard/user.
     * Forward messages to chatSocketHandler for server transfer.
     * @throws IOException propagates to main in Client
     */
    public void startChat() throws IOException {

        chatSocketHandler = new ChatSocketHandler(this, socket);
        // Chat can read from the keyboard while
        // ChatSocketHandler is listening to the server.
        Thread thread = new Thread(chatSocketHandler);
        thread.start();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String message = scanner.nextLine();

            if (message.equals("exit")) {
                chatSocketHandler.sendMessage("exit");
                socket.close();
                break;
            }

            chatSocketHandler.sendMessage(message);
        }
    }


    /**
     * Prints message to chat clients.
     * Messages fetched from server (in chatSocketHandler).
     * @param message = incoming message
     */
    public void getMessageFromChatHandler(String message) {
        System.out.println(message);
    }

}



