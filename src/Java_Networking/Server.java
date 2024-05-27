package Java_Networking;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000); // Create a server socket on port 5000
            System.out.println("Server started. Waiting for a client...");

            Socket clientSocket = serverSocket.accept(); // Wait for a client to connect
            System.out.println("Client connected.");

            // Get input and output streams from the socket
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read data from the client and echo it back
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Client: " + message);
                out.println("Server received: " + message);
            }

            // Close the streams and sockets
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
