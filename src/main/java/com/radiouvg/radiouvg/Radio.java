package com.radiouvg.radiouvg;

public class Radio implements RadioFunc{
    private boolean power = false;
    private double fq;
    private boolean band = false;
    private double volume;

    public Radio(){
        this.power = false;
        this.fq = 0;
        this.band = false;
        this.volume = 0;
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
