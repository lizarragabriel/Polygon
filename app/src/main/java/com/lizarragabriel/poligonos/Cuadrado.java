package com.lizarragabriel.poligonos;

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
}
