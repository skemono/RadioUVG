package com.radiouvg.radiouvg;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * La clase Radio implementa la interfaz RadioFunc y representa un objeto de radio.
 */
public class Radio implements RadioFunc {

    // Estado de encendido o apagado del radio
    private boolean power = false;

    // Frecuencia actual del radio
    private double fq;

    // Banda actual del radio (AM o FM)
    private boolean band = false;

    // Volumen actual del radio
    private double volume;

    // Lista de estaciones guardadas en el radio
    private ArrayList<Double> estacionesGuardadas = new ArrayList<>(Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9, 10.10, 11.11, 12.12));

    /**
     * Constructor de la clase Radio. Inicializa los valores predeterminados.
     */
    public Radio() {
        this.power = false;
        this.fq = 0;
        this.band = false;
        this.volume = 0;
    }

    /**
     * Obtiene la lista de estaciones guardadas en el radio.
     *
     * @return La lista de estaciones guardadas.
     */
    public ArrayList<Double> getEstacionesGuardadas() {
        return estacionesGuardadas;
    }

    /**
     * Establece la lista de estaciones guardadas en el radio.
     *
     * @param estacionesGuardadas La nueva lista de estaciones guardadas.
     */
    public void setEstacionesGuardadas(ArrayList<Double> estacionesGuardadas) {
        this.estacionesGuardadas = estacionesGuardadas;
    }

    @Override
    public void togglePower() {
        // Cambia el estado de encendido/apagado del radio.
        this.power = !this.power;
    }

    @Override
    public void switchAM() {
        // Cambia la banda del radio a AM.
        this.band = false;
    }

    @Override
    public void switchFM() {
        // Cambia la banda del radio a FM.
        this.band = true;
    }

    @Override
    public void changeFQ(double num) {
        // Cambia la frecuencia del radio según la banda actual.
        if (!this.band) {
            this.fq = 530 + (num * 10);
        } else if (this.band) {
            this.fq = 87.9 + (num * 0.2);
        }
    }

    @Override
    public void changeVol(int num) {
        // Cambia el volumen del radio.
        this.volume = num;
    }

    /**
     * Obtiene la frecuencia actual del radio.
     *
     * @return La frecuencia actual.
     */
    public double getFq() {
        return fq;
    }

    /**
     * Obtiene el volumen actual del radio.
     *
     * @return El volumen actual.
     */
    public double getVolume() {
        return volume;
    }

    /**
     * Obtiene la banda actual del radio (AM o FM).
     *
     * @return true si la banda es FM, false si es AM.
     */
    public boolean getBand() {
        return band;
    }

    /**
     * Obtiene el estado de encendido o apagado del radio.
     *
     * @return true si el radio está encendido, false si está apagado.
     */
    public boolean getPower() {
        return power;
    }
}
