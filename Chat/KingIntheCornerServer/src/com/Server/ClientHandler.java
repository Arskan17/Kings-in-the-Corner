package com.Server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

//When a client connects the server spawns a thread to handle the client.
//This way the server can handle multiple clients at the same time.

public class ClientHandler implements Runnable {

    // Array list of all the threads handling clients so each message can be sent to the client the thread is handling.
    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();

    // Socket for a connection, buffer reader and writer for receiving and sending data respectively.
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String clientUsername;

    // Creating the client handler from the socket the server passes.
    public ClientHandler(Socket socket) {
        try {
            this.socket = socket;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            // When a client connects their username is sent.
            this.clientUsername = bufferedReader.readLine();
            // Add the new client handler to the array so they can receive messages from others.
            clientHandlers.add(this);
            broadcastMessage("SERVER: " + clientUsername + " connected!");
        } catch (IOException e) {
            // Close everything more gracefully.
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    @Override
    public void run() {
        String messageFromClient;
        // Continue to listen for messages while a connection with the client is still established.
        while (socket.isConnected()) {
            try {
                // Read what the client sent and then send it to other connected clients.
                messageFromClient = bufferedReader.readLine();
                broadcastMessage(messageFromClient);
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }

    //Sends message to all connected Clients.
    public void broadcastMessage(String messageToSend) {
        for (ClientHandler clientHandler : clientHandlers) {
            try {
                // prevent self sending of messages. In other words, not receiving what one personally sends.
                if (!clientHandler.clientUsername.equals(clientUsername)) {
                    clientHandler.bufferedWriter.write(messageToSend);
                    clientHandler.bufferedWriter.newLine();
                    clientHandler.bufferedWriter.flush();
                }
            } catch (IOException e) {
                // Close socket and streams.
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    }

    // Close socket and streams to spare resources.
    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
//            System.out.println("Client disconnected!");
        }
    }
}
