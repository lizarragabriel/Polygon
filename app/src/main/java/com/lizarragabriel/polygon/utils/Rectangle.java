package com.lizarragabriel.polygon.utils;

import com.lizarragabriel.polygon.R;

public class Rectangle extends Figura {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double mCalculateArea() {
        return height * width;
    }

    @Override
    public double mCalculatePerimeter() {
        return height * 2 + width * 2;
    }

    @Override
    public String mFormula() {
        return "b * a";
    }

    @Override
    public int getImage() {
        return R.drawable.rectangle;
    }
}
