module com.example.chatimp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.chatimp to javafx.fxml;
    exports com.example.chatimp;
}