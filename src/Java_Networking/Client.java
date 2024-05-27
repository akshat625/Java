package Java_Networking;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000); // Connect to the server running on localhost at port 5000
            System.out.println("Connected to server.");

            // Get input and output streams from the socket
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send data to the server and read response
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String message;
            while ((message = userInput.readLine()) != null) {
                out.println(message); // Send data to server
                System.out.println("Server: " + in.readLine()); // Receive response from server
            }

            // Close the streams and socket
            userInput.close();
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

