package Login;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class LobbyController implements Initializable {
    @FXML
    private Button btn_Ausloggen;
    @FXML
    private Button btn_Konto;
    @FXML
    private Button btn_Beitreten;
    @FXML
    private Button btn_Bestenliste;
    @FXML
    private Button btn_Chat;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btn_Ausloggen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            DBUtils.SeiteWechseln(event,"hello-view.fxml", "Anmelden",null);
            }
        });

        btn_Beitreten.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {DBUtils.SeiteWechseln(event, "SpielEinstellung.fxml", "Beitreten", null);}
        });

        btn_Bestenliste.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {DBUtils.SeiteWechseln(event, "Bestenliste.fxml", "Bestenliste", null);}
        });

        btn_Chat.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {DBUtils.SeiteWechseln(event, "chat-view.fxml", "chat-view", null);}
        });

        btn_Konto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {DBUtils.SeiteWechseln(event, "Konto.fxml", "Konto", null);}
        });
    }
}
