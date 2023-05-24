package com.lizarragabriel.polygon.utils;

import com.lizarragabriel.polygon.R;

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

    @Override
    public String mFormula() {
        return "b * a";
    }

    @Override
    public int getImage() {
        return R.drawable.triangle;
    }
}
