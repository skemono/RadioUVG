package com.radiouvg.radiouvg;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;


import java.net.URL;
import java.text.DecimalFormat;
import java.util.Objects;
import java.util.ResourceBundle;

public class RadioController implements Initializable {

    private Radio radioNashe;
    @FXML
    private Button amBton;

    private boolean saveOrNa;

    @FXML
    private GridPane gridNashe;

    @FXML
    private Button fmBton;

    @FXML
    private ImageView fqPin;

    @FXML
    private Slider fqSlider;

    @FXML
    private Button powerBton;

    @FXML
    private ProgressBar volBar;

    @FXML
    private Slider volSlider;

    @FXML
    private Text volIndicator;

    @FXML
    private Text fqIndicator;

    @FXML
    private Button btonEstacion;

    public  RadioController(){
        this.radioNashe = RadioApp.getRadio();
        this.saveOrNa = true;
        Platform.runLater(() -> {
            int count = 0;
            for (Node node : this.gridNashe.getChildren()) {
                if (node instanceof Button) {
                    Button button = (Button) node;
                    button.setText("-");
                    count += 1;
                    int finalCount = count;
                    button.setOnAction(event -> saveOrNashe(finalCount));
                }
            }
        });
    }

    @FXML
    void loadOrSave(ActionEvent event) {
        if (saveOrNa){
            saveOrNa = false;
            btonEstacion.setText("Cargar");
        }else{
            saveOrNa = true;
            btonEstacion.setText("Guardar");
        }
    }

    private EventHandler<ActionEvent> saveOrNashe(int i){
        int count = 0;
        for (Node node : gridNashe.getChildren()) {
            count += 1;
            if (node instanceof Button) {
                if (count == i){
                    Button button = (Button) node;
                    if (saveOrNa){
                        String noLettersString = fqIndicator.getText().replaceAll("[a-zA-Z]", "");
                        button.setText(String.valueOf(noLettersString));
                    } else {
                        if (!Objects.equals(button.getText(), "-")){
                            double getFq = Double.parseDouble(button.getText());
                            if (getFq > 110){
                                radioNashe.switchAM();
                                fqSlider.setValue((getFq - 530)/10 );
                                radioNashe.changeFQ(getFq);
                            } else {
                                radioNashe.switchFM();
                                fqSlider.setValue((getFq - 87.9 )/0.2);
                                radioNashe.changeFQ(getFq);
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fqSlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldNumber, Number newNumber) {

                if (!radioNashe.getBand()){
                    fqPin.setLayoutY(348 - (fqSlider.getValue() * ((double) 325 /108)));
                    radioNashe.changeFQ(530 + (fqSlider.getValue() * 10));
                    fqIndicator.setText(530 + ((int) fqSlider.getValue() * 10) + "kHz");

                } else{
                    fqPin.setLayoutY(348 - (fqSlider.getValue() * ((double) 325 /100)));
                    radioNashe.changeFQ(87.9 + ((int) fqSlider.getValue() * 0.2));
                    DecimalFormat df = new DecimalFormat("###.#");
                    fqIndicator.setText( df.format((87.9 + ((int) fqSlider.getValue() * 0.2))) + "MHz");
                }

            }
        });

        volSlider.valueProperty().addListener(new ChangeListener<Number>() {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldNumber, Number newNumber) {

                volBar.setProgress(volSlider.getValue() / 100);
                volIndicator.setText(String.valueOf ((int) volSlider.getValue()) );

            }
        });

    }

    @FXML
    void amOn(ActionEvent event) {
        radioNashe.switchAM();
        fqSlider.setMax(108);
        if (fqSlider.getValue() == 0){
            fqSlider.setValue(1);
            fqSlider.setValue(0);
        }
        fqSlider.setValue(fqSlider.getValue() / 100 * 108);
        amBton.setDisable(true);
        fmBton.setDisable(false);
    }

    @FXML
    void fmOn(ActionEvent event) {
        radioNashe.switchFM();
        if (fqSlider.getValue() == 0){
            fqSlider.setValue(1);
            fqSlider.setValue(0);
        }
        fqSlider.setValue(fqSlider.getValue() / 108 * 100);
        fqSlider.setMax(100);
        fmBton.setDisable(true);
        amBton.setDisable(false);
    }

    @FXML
    void togglePower(ActionEvent event) {
        radioNashe.togglePower();
        if (radioNashe.getPower()){
            fqSlider.setDisable(false);
            volSlider.setDisable(false);
            amBton.setDisable(false);
            fmBton.setDisable(false);
        } else{
            fqSlider.setDisable(true);
            volSlider.setDisable(true);
            amBton.setDisable(true);
            fmBton.setDisable(true);
        }
    }

}
