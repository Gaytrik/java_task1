package javatask_10;

import java.io.*;
import java.net.*;

public class ChatClient {

    private static final String HOST = "localhost";
    private static final int PORT = 1234;

    public static void main(String[] args) {

        try (
                Socket socket = new Socket(HOST, PORT);
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.println("Connected to server. Start chatting:");

            // Thread to read messages from server
            new Thread(() -> {
                String serverMsg;
                try {
                    while ((serverMsg = in.readLine()) != null) {
                        System.out.println(">> " + serverMsg);
                    }
                } catch (IOException e) {
                    System.out.println("Connection closed");
                }
            }).start();

            // Send messages to server
            String userInput;
            while ((userInput = input.readLine()) != null) {
                out.println(userInput);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}