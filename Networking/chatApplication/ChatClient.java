import java.io.*;
import java.net.*;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, PORT);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("✅ Connected to Chat Server!");
            
            // Read welcome message first
            String serverResponse = input.readLine();  
            System.out.println(serverResponse);
            
            // Enter username
            System.out.print("📝 Enter your username: ");
            String username = userInput.readLine();
            output.println(username);  // Send username to server

            // Thread to read messages from server
            new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = input.readLine()) != null) {
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            // Read user input and send messages
            String message;
            while ((message = userInput.readLine()) != null) {
                output.println(message);
                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("🚪 Exiting chat...");
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
