package com.example.anmelden;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;



public class RegistrierenController implements Initializable {
    @FXML
    private Button btn_Registrieren;

    @FXML
    private RadioButton radio;

    @FXML
    private TextField tf_usernameRegistrieren;

    @FXML
    private PasswordField tf_passwordRegistrieren;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    btn_Registrieren.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if(!tf_usernameRegistrieren.getText().trim().isEmpty() && !tf_passwordRegistrieren.getText().trim().isEmpty()){
                DBUtils.UserRegistrieren(event,tf_usernameRegistrieren.getText(),tf_passwordRegistrieren.getText());
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Bitte alle felder ausfüllen");
                alert.show();
            }
        }
    });

    }
}
