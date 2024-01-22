package com.Chat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.Socket;

import java.io.IOException;

public class ChatApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ChatApplication.class.getResource("chat-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 480);
        stage.setTitle("Client");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        Client.start();
        //launch GUI
        launch();

    }
}