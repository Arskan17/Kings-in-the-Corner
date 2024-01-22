module com.example.anmelden {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.anmelden to javafx.fxml;
    exports com.example.anmelden;
}