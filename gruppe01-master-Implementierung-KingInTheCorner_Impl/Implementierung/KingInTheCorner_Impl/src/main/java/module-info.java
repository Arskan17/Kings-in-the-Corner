module gui.login {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.rmi;

    exports ChatGUI;
    opens ChatGUI to javafx.fxml;
    exports Login;
    opens Login to javafx.fxml;
}