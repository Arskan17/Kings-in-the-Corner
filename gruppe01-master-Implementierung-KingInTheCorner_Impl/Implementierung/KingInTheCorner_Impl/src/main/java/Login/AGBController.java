package Login;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;



public class AGBController implements Initializable {
    @FXML
    private Button btn_zurueck;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_zurueck.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DBUtils.SeiteWechseln(event,"Registerieren.fxml","Registrieren",null);
            }
        });
    }
}
