package com.example.anmelden;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class LobbyController implements Initializable {
    @FXML
    private Button btn_Ausloggen;
    @FXML
    private Label lb_SeitenichtVorhanden;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btn_Ausloggen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            DBUtils.SeiteWechseln(event,"hello-view.fxml", "Anmelden",null);
            }
        });

    }
    public void setLb_SeitenichtVorhanden(String Username){
        lb_SeitenichtVorhanden.setText("Hallo "+ Username+" diese Seite ist leider nicht verfügbar");
    }
}
