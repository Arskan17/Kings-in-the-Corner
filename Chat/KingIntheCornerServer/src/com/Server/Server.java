package com.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void startServer() {
        try {
            // Listens for clients connections on port 4711.
            while (!serverSocket.isClosed()) {
                // Since after every connection the socket gets closed,
                // the only way to detect new clients is of it gets reopened.
                Socket socket = serverSocket.accept();
//                System.out.println("New Client connection.");
                ClientHandler clientHandler = new ClientHandler(socket);  //new instance to manage the client is created,
                Thread thread = new Thread(clientHandler);               //and assigned a thread.
                thread.start();
            }
        } catch (IOException e) {
            closeServerSocket();
        }
    }

    // Closes the socket to avoid wasting resources.
    public void closeServerSocket() {
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4711);
        Server server = new Server(serverSocket);
        server.startServer();
    }

}
