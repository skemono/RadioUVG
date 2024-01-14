package com.radiouvg.radiouvg;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.beans.value.ObservableValue;
import javafx.scene.text.Text;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class RadioController implements Initializable {

    private Radio radioNashe;
    @FXML
    private Button amBton;

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

    public  RadioController(){
        this.radioNashe = RadioApp.getRadio();
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
