package com.lizarragabriel.poligonos;

public class Circle extends Figura {
    private double mRadio;

    public Circle(double mRadio) {
        this.mRadio = mRadio;
    }

    public double getmRadio() {
        return mRadio;
    }

    @Override
    public double mCalculateArea() {
        return Math.PI * Math.pow(mRadio, 2);
    }

    @Override
    public double mCalculatePerimeter() {
        return 2 * Math.PI * mRadio;
    }
}
