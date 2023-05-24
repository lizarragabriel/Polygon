package com.lizarragabriel.polygon.utils;

import com.lizarragabriel.polygon.R;

public class Cuadrado extends Figura {
    private double base;

    public Cuadrado(double base) {
        this.base = base;
    }

    public double getBase() {
        return base;
    }

    @Override
    public double mCalculateArea() {
        return Math.pow(base, 2);
    }

    @Override
    public double mCalculatePerimeter() {
        return base * 4;
    }

    @Override
    public String mFormula() {
        return "L * L";
    }

    @Override
    public int getImage() {
        return R.drawable.square;
    }
}
