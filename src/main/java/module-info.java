module com.example.calcapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.calcapp to javafx.fxml;
    exports com.example.calcapp;
}