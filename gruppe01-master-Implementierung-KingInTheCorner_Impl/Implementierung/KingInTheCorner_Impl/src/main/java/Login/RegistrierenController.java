package Login;

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
    private Button btn_LRegistrieren_Login;

    @FXML
    private Button btn_AGB;

    @FXML
    private PasswordField tf_passwordRegistrieren;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    btn_Registrieren.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if(!tf_usernameRegistrieren.getText().trim().isEmpty() && !tf_passwordRegistrieren.getText().trim().isEmpty() && radio.isSelected()){
                DBUtils.UserRegistrieren(event,tf_usernameRegistrieren.getText(),tf_passwordRegistrieren.getText());
            }else if(!radio.isSelected()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Bitte den AGBs zustimmen");
                alert.show();
            } else{Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Bitte alle felder ausfüllen");
                alert.show();
            }
        }
    });

    btn_LRegistrieren_Login.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            DBUtils.SeiteWechseln(event,"hello-view.fxml","Login",null);
        }
    });

    btn_AGB.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            DBUtils.SeiteWechseln(event,"AGB.fxml","AGBs" ,null);
        }
    });
    }
}
