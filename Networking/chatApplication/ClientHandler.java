import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private String username;
    private static Set<ClientHandler> clientHandlers;

    public ClientHandler(Socket socket, Set<ClientHandler> handlers) {
        this.clientSocket = socket;
        clientHandlers = handlers;
        try {
            this.out = new PrintWriter(clientSocket.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            out.println("📝 Enter your username:");
            while (username == null || username.trim().isEmpty()) {  
                username = in.readLine();  // Read username until it's valid
            }
            
            System.out.println("👤 " + username + " has joined the chat!");
            broadcastMessage("📢 " + username + " has joined the chat!", null);

            String message;
            while ((message = in.readLine()) != null) {
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
                broadcastMessage(username + ": " + message, this);
            }

            closeConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void broadcastMessage(String message, ClientHandler sender) {
        for (ClientHandler client : clientHandlers) {
            if (client != sender) {
                client.out.println(message);
            }
        }
    }

    private void closeConnection() {
        try {
            clientHandlers.remove(this);
            clientSocket.close();
            System.out.println("❌ " + username + " has left the chat.");
            broadcastMessage("📢 " + username + " has left the chat.", null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
