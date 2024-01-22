package com.Spielraum;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SpielraumApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.Spielraum.SpielraumApplication.class.getResource("spielraum-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 500);
        stage.setTitle("Spielraum");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}