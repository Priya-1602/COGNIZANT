import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        int port = 12345;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started. Waiting for client to connect...");
            try (Socket clientSocket = serverSocket.accept()) {
                System.out.println("Client connected.");
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
                String clientMsg, serverMsg;
                System.out.println("Type messages to send to client. Type 'exit' to quit.");
                while (true) {
                    if (in.ready()) {
                        clientMsg = in.readLine();
                        if (clientMsg == null || clientMsg.equalsIgnoreCase("exit")) {
                            System.out.println("Client disconnected.");
                            break;
                        }
                        System.out.println("Client: " + clientMsg);
                    }
                    if (userInput.ready()) {
                        serverMsg = userInput.readLine();
                        out.println(serverMsg);
                        if (serverMsg.equalsIgnoreCase("exit")) {
                            System.out.println("Server exiting.");
                            break;
                        }
                    }
                    Thread.sleep(100);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}