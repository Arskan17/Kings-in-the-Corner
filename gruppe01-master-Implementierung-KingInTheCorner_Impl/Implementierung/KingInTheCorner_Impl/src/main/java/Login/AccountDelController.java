package Login;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountDelController implements Initializable {

    @FXML
    private Button btn_zuruck;
    @FXML
    private Button btn_Kontoloschen;
    @FXML
    private CheckBox box_Bestatigen;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btn_zuruck.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {DBUtils.SeiteWechseln(event, "Konto.fxml", "Konto", null);}
        });


    }
}
