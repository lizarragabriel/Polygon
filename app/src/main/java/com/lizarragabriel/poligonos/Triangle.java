package com.lizarragabriel.poligonos;

public class Triangle extends Figura {
    private double width;
    private double height;

    public Triangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double mCalculateArea() {
        return width * height / 2;
    }

    @Override
    public double mCalculatePerimeter() {
        return width * 3;
    }
}
