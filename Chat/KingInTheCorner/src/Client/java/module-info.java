module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.Chat to javafx.fxml;
    exports com.Chat;
}