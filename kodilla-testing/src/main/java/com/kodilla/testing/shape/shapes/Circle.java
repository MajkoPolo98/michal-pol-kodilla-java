package com.kodilla.testing.shape.shapes;

import com.kodilla.testing.shape.Shape;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public String getShapeName() {
        return "Circle";
    }

    public double getField() {
        return (3.1415*radius*radius);
    }
}