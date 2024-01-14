package com.radiouvg.radiouvg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RadioApp extends Application {

    private static Radio radionashe;
    @Override
    public void start(Stage stage) throws IOException {
        radionashe = new Radio();
        FXMLLoader fxmlLoader = new FXMLLoader(RadioApp.class.getResource("RadioUVG.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 400);
        stage.setTitle("Radio UVG");
        stage.setScene(scene);
        stage.show();
    }

    public static Radio getRadio() {return radionashe;}
    public static void main(String[] args) {
        launch();
    }
}