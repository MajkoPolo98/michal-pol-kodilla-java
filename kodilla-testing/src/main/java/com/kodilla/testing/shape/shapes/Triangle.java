package com.kodilla.testing.shape.shapes;

import com.kodilla.testing.shape.Shape;

public class Triangle implements Shape {
    private double height;
    private double base;

    public Triangle(double height, double base) {
        this.height = height;
        this.base = base;
    }

    public String getShapeName(){
        return "Triangle";
    }
    public double getField() {
        return (base*height*0.5);
    }

}