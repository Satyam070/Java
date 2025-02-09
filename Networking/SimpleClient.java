import java.io.*;
import java.net.*;

public class SimpleClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);  // Connect to server at port 5000

            // Send message to server
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            output.println("Hello from the Client!");

            // Receive message from server
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverMessage = input.readLine();
            System.out.println("Server says: " + serverMessage);

            socket.close();  // Close connection
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
