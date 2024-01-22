package com.example.anmelden;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.sql.*;

import java.io.IOException;

public class DBUtils {

    public static void SeiteWechseln(ActionEvent event, String fxmlFile, String titel, String username){

        Parent root = null;

        if(username!= null){
            try {
                FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource(fxmlFile));
                root= loader.load();
                LobbyController lobbyController = loader.getController();
                lobbyController.setLb_SeitenichtVorhanden(username);
            }catch (IOException e){
                e.printStackTrace();
            }
        } else{
            try {
                root = FXMLLoader.load((DBUtils.class.getResource(fxmlFile)));
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(titel);
        stage.setScene(new Scene(root,600,400));
        stage.show();
    }

    public static void UserRegistrieren (ActionEvent event, String username, String password){
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckerUserExists = null;
        ResultSet resultSet = null;

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kitc", "root", "uiop");
            psCheckerUserExists = connection.prepareStatement("SELECT * FROM anmeldung WHERE Name = ?");
            psCheckerUserExists.setString(1,username);
            resultSet = psCheckerUserExists.executeQuery();

            if(resultSet.isBeforeFirst()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Benutzername bereits vergeben");
                alert.show();
            }else {
                psInsert = connection.prepareStatement("INSERT INTO Userdata (Name, passwort VALUES (?,?))");
                psInsert.setString(1,username);
                psInsert.setString(2,password);
                psInsert.executeUpdate();

                SeiteWechseln(event,"Lobby.fxml","Willkommen",username);
            }
        }catch (SQLException e){e.printStackTrace();

        }finally {
            if(resultSet != null){
                try {


                resultSet.close();
                }catch (SQLException e){e.printStackTrace();
            }
        }
            if(psCheckerUserExists != null){
                try {


                    psCheckerUserExists.close();
                }catch (SQLException e){e.printStackTrace();
                }
    }
            if(psInsert != null){
                try {


                    psInsert.close();
                }catch (SQLException e){e.printStackTrace();
                }
    }
            if(connection != null){
                try {


                    connection.close();
                }catch (SQLException e){e.printStackTrace();
                }
            }
}
    }
    public static  void loginUser (ActionEvent event, String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kitc", "root", "Ap80f@k7O07x5tr@");
            preparedStatement = connection.prepareStatement("SELECT passwort FROM anmeldung WHERE Name = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(" Benutzername ist falsch");
                alert.show();
            } else {
                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString("Passwort");
                    if (retrievedPassword.equals(password)) {
                        SeiteWechseln(event, "Lobby.fxml", "Willkommen" + username, username);
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Passwort ist Falsch");
                        alert.show();
                    }
                }


            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {


            if (resultSet != null) {
                try {
                    resultSet.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}