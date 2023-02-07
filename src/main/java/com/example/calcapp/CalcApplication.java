package com.example.calcapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CalcApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(CalcApplication.class.getResource("calc_View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 420, 620);
        stage.setTitle("Калькулятор");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}