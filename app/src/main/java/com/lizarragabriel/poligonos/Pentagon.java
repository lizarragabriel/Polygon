package com.lizarragabriel.poligonos;

public class Pentagon extends Figura {
    private double base;
    private double apothem;

    public Pentagon(double base, double apothem) {
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
        return base * 5;
    }
}
