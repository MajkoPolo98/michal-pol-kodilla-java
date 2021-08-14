package com.kodilla.testing.shape.shapes;

import com.kodilla.testing.shape.Shape;

public class Square implements Shape {
    private double base;

    public Square(double base) {
        this.base = base;
    }

    public String getShapeName() {
        return "Square";
    }

    public double getField() {
        return (base*base);
    }
}