import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
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
            out.println("📢 Welcome to the Chat! Type 'exit' to leave.");
            String message;

            while ((message = in.readLine()) != null) {
                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println("📩 Message received: " + message);
                broadcastMessage(message);
            }

            closeConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void broadcastMessage(String message) {
        for (ClientHandler client : clientHandlers) {
            if (client != this) {
                client.out.println("👤 " + message);
            }
        }
    }

    private void closeConnection() {
        try {
            clientHandlers.remove(this);
            clientSocket.close();
            System.out.println("❌ Client disconnected.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
