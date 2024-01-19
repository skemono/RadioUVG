package com.radiouvg.radiouvg;

import java.util.ArrayList;
import java.util.Arrays;

public class Radio implements RadioFunc{
    private boolean power = false;
    private double fq;
    private boolean band = false;
    private double volume;

    private ArrayList<Double> estacionesGuardadas = new ArrayList<>(Arrays.asList(1.1,2.2,3.3,4.4,5.5,6.6,7.7,8.8,9.9,10.10,11.11,12.12));

    public Radio(){
        this.power = false;
        this.fq = 0;
        this.band = false;
        this.volume = 0;
    }

    public ArrayList<Double> getEstacionesGuardadas() {
        return estacionesGuardadas;
    }

    public void setEstacionesGuardadas(ArrayList<Double> estacionesGuardadas) {
        this.estacionesGuardadas = estacionesGuardadas;
    }

    @Override
    public void togglePower() {
        if (this.power){
            this.power = false;
        } else {
            this.power = true;
        }
    }

    @Override
    public void switchAM() {
        this.band = false;
    }

    @Override
    public void switchFM() {
        this.band = true;
    }

    @Override
    public void changeFQ(double num) {
        if (!this.band){
            this.fq = 530 + (num * 10);
        } else if (this.band) {
            this.fq = 87.9 + (num * 0.2);
        }
    }

    @Override
    public void changeVol(int num) {
        this.volume = num;
    }

    public double getFq() {
        return fq;
    }

    public double getVolume() {
        return volume;
    }

    public boolean getBand() {
        return band;
    }

    public boolean getPower() {
        return power;
    }
}
