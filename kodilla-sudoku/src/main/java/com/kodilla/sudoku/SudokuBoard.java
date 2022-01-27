package com.kodilla.sudoku;

import com.kodilla.sudoku.prototype.Prototype;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

@Getter
public class SudokuBoard extends Prototype<SudokuBoard> {
    ArrayList<SudokuRow> rows = new ArrayList<>();

    public SudokuBoard() {
        for (int rowNumber = 0; rowNumber <9; rowNumber++){
            SudokuRow row = new SudokuRow(rowNumber);
            rows.add(row);
        }
    }

    public List<SudokuElement> getOccupiedElements(){
        return rows.stream().flatMap(row -> row.getRowElements().stream()).filter(element -> !element.getValue().equals(SudokuElement.EMPTY)).collect(Collectors.toList());
    }
    public List<SudokuElement> getEmptyElements(){
        return rows.stream().flatMap(row -> row.getRowElements()
                .stream()).filter(element -> element.getValue().equals(SudokuElement.EMPTY)).collect(Collectors.toList());
    }

    public List<SudokuElement> getRowElements(SudokuElement sudokuElement){
        return rows.get(sudokuElement.getRow()).getRowElements().stream()
                .filter(element -> element != sudokuElement)
                .collect(Collectors.toList());
    }


    public List<SudokuElement> getColumnElements(SudokuElement sudokuElement){
        return rows.stream().map(sudokuRow -> sudokuRow.getRowElements().get(sudokuElement.getCol()))
                .filter(element -> sudokuElement != element)
                .collect(Collectors.toList());
    }

    public List<SudokuElement> getBoxElements(SudokuElement sudokuElement){
        int boxRow = sudokuElement.getRow()/3;
        int boxCol = sudokuElement.getCol()/3;

        return rows.stream().flatMap(row -> row.getRowElements().stream()).
                filter(element -> element.getRow()/3 == boxRow &&
                        element.getCol()/3 == boxCol &&
                        element != sudokuElement).collect(Collectors.toList());
    }

    public List<SudokuElement> getEmptyElements2(){
        return rows.stream()
                .flatMap(row -> row.getRowElements().stream())
                .filter(el-> el.getValue() == SudokuElement.EMPTY)
                .collect(Collectors.toList());
    }


    public SudokuElement getElement(int row, int col){
        return rows.get(row).getRowElements().get(col);
    }

    public void setElement(int row, int col, int value){
        getElement(row, col).setValue(value);
    }

    @Override
    public String toString() {
        Iterator<SudokuRow> iterator = rows.iterator();
        String string = "";
        while (iterator.hasNext()){
            SudokuRow row = iterator.next();
            if (row.getRowNumber()%3 == 0) {
                string += "\n||===|===|===||===|===|===||===|===|===||\n";
            } else {
                string += "\n||---|---|---||---|---|---||---|---|---||\n";
            }
            string +=  row.toString();
        }
        return string + "\n||===|===|===||===|===|===||===|===|===||\n";
    }


    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard clonedBoard = super.clone();
        clonedBoard.rows = new ArrayList<>();
        for(SudokuRow row: getRows()){
            SudokuRow clonedRow = new SudokuRow(row.getRowNumber());
            for (SudokuElement element: row.getRowElements()){
                SudokuElement clonedElement = new SudokuElement(element.getValue(), element.getCol(), element.getRow());
                clonedElement.getPossibleValues().clear();
                for(Integer poss: element.getPossibleValues())
                clonedElement.getPossibleValues().add(poss);
                clonedRow.getRowElements().set(clonedElement.getCol(), clonedElement);
            }
            clonedBoard.getRows().add(clonedRow);
        }
        return clonedBoard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SudokuBoard)) return false;

        SudokuBoard that = (SudokuBoard) o;

        return Objects.equals(rows, that.rows);
    }

    @Override
    public int hashCode() {
        return rows != null ? rows.hashCode() : 0;
    }
}
