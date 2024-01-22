package Login;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public LoginController(){

    }

    @FXML
    private Button buttonAnmelden;
    @FXML
    private Button buttonRegistrieren;
    @FXML
    private Label wrongLogIn;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttonAnmelden.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {System.out.println("Wechsel Lobby");
                DBUtils.loginUser(event,username.getText(),password.getText());
            }
        });
        buttonRegistrieren.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                DBUtils.SeiteWechseln(event,"Registerieren.fxml","Registrieren",null);
            }
        });


    }
}
