import java.io.*;
import java.net.*;

public class SimpleServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);  // Start server on port 5000
            System.out.println("Server is waiting for a client...");

            Socket socket = server.accept();  // Accept client connection
            System.out.println("Client connected!");

            // Read message from client
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String clientMessage = input.readLine();
            System.out.println("Client says: " + clientMessage);

            // Send response to client
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            output.println("Hello from the Server!");

            socket.close();  // Close connection
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
