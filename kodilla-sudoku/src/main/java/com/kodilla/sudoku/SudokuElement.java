package com.kodilla.sudoku;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class SudokuElement {

    private Integer value;
    private int col;
    private int row;
    private ArrayList<Integer> possibleValues = new ArrayList<>();
    public static int EMPTY = -1;

    public SudokuElement(Integer value, int col, int row) {
        this.value = value;
        this.col = col;
        this.row = row;

        for(int i=1; i<=9; i++){
            this.possibleValues.add(i);
        }
    }

    public void setValue(Integer newValue){
        this.value = newValue;
        possibleValues.clear();
        possibleValues.add(newValue);
    }

    public void setPossibleValues(ArrayList<Integer> possibleValues) {
        this.possibleValues = possibleValues;
    }

    public void removePossibility(Integer value){
        this.possibleValues.remove(value);
    }

    @Override
    public String toString() {
        if (value > 0) {
            return " " + value + " ";
        } else {
            return "   ";
        }
    }
}
