package com.lizarragabriel.polygon.utils;

import com.lizarragabriel.polygon.R;

public class Hexagon extends Figura {
    private double base;
    private double apothem;


    public Hexagon(double base, double apothem) {
        this.base = base;
        this.apothem = apothem;
    }

    public double getBase() {
        return base;
    }

    public double getApothem() {
        return apothem;
    }

    @Override
    public double mCalculateArea() {
        return mCalculatePerimeter() * apothem / 2;
    }

    @Override
    public double mCalculatePerimeter() {
        return base * 6;
    }

    @Override
    public String mFormula() {
        return "L * H";
    }

    @Override
    public int getImage() {
        return R.drawable.hexagon;
    }
}
