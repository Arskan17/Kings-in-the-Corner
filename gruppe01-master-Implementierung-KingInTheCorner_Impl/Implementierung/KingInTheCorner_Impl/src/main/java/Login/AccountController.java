package Login;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AccountController implements Initializable {

    @FXML
    private Button btn_Datenandern;
    @FXML
    private CheckBox box_betatigen;
    @FXML
    private Button btn_zuruck;
    @FXML
    private Button btn_Kontoloschen;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btn_zuruck.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {DBUtils.SeiteWechseln(event, "Lobby.fxml", "Lobby", null);}
        });

        btn_Kontoloschen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {DBUtils.SeiteWechseln(event, "Kontoloeschen.fxml", "Kontoloeschen", null);}
        });

    }
}
