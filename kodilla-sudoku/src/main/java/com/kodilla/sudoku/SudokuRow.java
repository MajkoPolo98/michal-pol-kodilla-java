package com.kodilla.sudoku;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Iterator;

@Getter
public class SudokuRow {
    private ArrayList<SudokuElement> rowElements = new ArrayList<>();
    private int rowNumber;

    public SudokuRow(int rowNumber) {
        this.rowNumber = rowNumber;
        for (int col=0; col<9; col++){
            this.rowElements.add(new SudokuElement(SudokuElement.EMPTY, col, rowNumber));
        }
    }

    @Override
    public String toString() {
        Iterator<SudokuElement> iterator = rowElements.iterator();
        String string = "";
        while(iterator.hasNext()){
            SudokuElement element = iterator.next();
            if (element.getCol()%3 == 0) {
                string += "|";
            }
            string += "|" + element;
        }
        return string + "||";
    }
}
