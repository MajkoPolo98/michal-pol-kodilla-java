package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    private List<Shape> collection = new ArrayList<>();

    public void addFigure(Shape shape){
        collection.add(shape);
    }
    public boolean removeFigure(Shape shape) {
        if (collection.contains(shape)) {
            collection.remove(shape);
            return true;
        } else
            return false;
    }
    public Shape getFigure(int n){
        if (n >= 0 && n < collection.size()) {
            return collection.get(n);
        }
        return null;
    }
    public List<String> showFigures(){
        List<String> figureNames = new ArrayList<>();
        for (Shape figure: collection){
            System.out.println(figure.getShapeName());
            figureNames.add(figure.getShapeName());
        }
        return figureNames;
    }
    public int getFiguresQuantity(){
        return collection.size();
    }
}
