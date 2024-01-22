package com.Chat;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.Socket;
import java.io.*;

public class Client{
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String username;

    @FXML private TextField ChatTextField;

    //To display messages in the window.
    @FXML static ListView<String> ShowChatMessages;

    public static void start() throws IOException{
        String username = "Group1";
        // Creates a socket to connect to the server.
        Socket socket = new Socket("localhost", 4711);

        // Passes the socket and client's username.
        Client client = new Client(socket, username);
        client.listenForMessage();
        client.sendMessage();
    }

    public Client(Socket socket, String username) {
        try {
            this.socket = socket;
            this.username = username;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    public void sendMessage() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Initially send the username of the client.
                    bufferedWriter.write(username);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                    // Continues to sending the message.
                    while (socket.isConnected()) {
                        String sendInputText = ChatTextField.getText().toString();
                        ChatTextField.clear();
                        if (!sendInputText.isEmpty()){
                            ShowChatMessages.getItems().add("me" + sendInputText);
                            bufferedWriter.write(username + ": " + sendInputText);
                            bufferedWriter.newLine();
                            bufferedWriter.flush();
                        }
                    }
                } catch (IOException e) {
                    closeEverything(socket, bufferedReader, bufferedWriter);
                }
            }
        }).start();
    }

    public void listenForMessage() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String incomingMessages;
                // While there is still a connection with the server, continue to listen for messages on a separate thread.
                while (socket.isConnected()) {
                    try {
                        // Get the messages sent from other users.
                        incomingMessages = bufferedReader.readLine();
                        ShowChatMessages.getItems().add(incomingMessages);
                    } catch (IOException e) {
                        closeEverything(socket, bufferedReader, bufferedWriter);
                    }
                }
            }
        }).start();
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
        }
    }
}
