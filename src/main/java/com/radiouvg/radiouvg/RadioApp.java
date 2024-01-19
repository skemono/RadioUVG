package com.radiouvg.radiouvg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * La clase principal para la aplicación de Radio UVG.
 */
public class RadioApp extends Application {

    // La instancia de Radio para la aplicación
    private static Radio radionashe;

    /**
     * Punto de entrada para la aplicación JavaFX.
     *
     * @param stage El escenario principal de la aplicación.
     * @throws IOException Si ocurre un error al cargar el archivo FXML.
     */
    @Override
    public void start(Stage stage) throws IOException {
        radionashe = new Radio();
        FXMLLoader fxmlLoader = new FXMLLoader(RadioApp.class.getResource("RadioUVG.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 400);
        stage.setTitle("Radio UVG");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Obtiene la instancia de Radio para la aplicación.
     *
     * @return La instancia de Radio.
     */
    public static Radio getRadio() {
        return radionashe;
    }

    /**
     * El método principal para iniciar la aplicación.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        launch();
    }
}
