package com.radiouvg.radiouvg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RadioApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(RadioApp.class.getResource("RadioUVG.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 400);
        stage.setTitle("Radio UVG");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}