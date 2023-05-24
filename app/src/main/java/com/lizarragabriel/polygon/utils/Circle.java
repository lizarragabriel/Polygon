package com.lizarragabriel.polygon.utils;

import com.lizarragabriel.polygon.R;

public class Circle extends Figura {
    private double mRadio;

    public Circle(double mRadio) {
        this.mRadio = mRadio;
    }

    public double getmRadio() {
        return mRadio;
    }

    public void setmRadio(double mRadio) {
        this.mRadio = mRadio;
    }

    @Override
    public double mCalculateArea() {
        return Math.PI * Math.pow(mRadio, 2);
    }

    @Override
    public double mCalculatePerimeter() {
        return 2 * Math.PI * mRadio;
    }

    @Override
    public String mFormula() {
        return "PI * r";
    }

    @Override
    public int getImage() {
        return R.drawable.circulo;
    }
}
