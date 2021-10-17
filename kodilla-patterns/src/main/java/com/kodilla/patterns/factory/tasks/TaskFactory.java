package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String DRIVING = "DRIVING";
    public static final String PAINTING = "PAINTING";
    public static final String SHOPPING = "SHOPPING";

    public Task makeTask(String shapeClass){
        switch (shapeClass){
            case DRIVING:
                return new DrivingTask("driving", "Portugal", "Car");
            case PAINTING:
                return new PaintingTask("painting", "Red", "Fence");
            case SHOPPING:
                return new ShoppingTask("shopping", "Bananas", 5);
            default:
                return null;
        }
    }
}
