module com.example.oopassignment4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.oopassignment4 to javafx.fxml;
    exports com.example.oopassignment4;
}