package com.kodilla.sudoku;

import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

@Setter
@Getter
public class SudokuGame {
    private SudokuBoard board;

    public SudokuGame(SudokuBoard board) {
        this.board = board;
    }

    public boolean isBoardFull(){
        return board.getRows().stream().flatMap(sudokuRow -> sudokuRow.getRowElements().stream()).
                filter(sudokuElement -> sudokuElement.getValue() == SudokuElement.EMPTY).count() == 0;
    }

    public void removeRowPossibilities(SudokuElement sudokuElement){
        board.getRowElements(sudokuElement).stream()
                .filter(element -> element.getValue() == SudokuElement.EMPTY)
                .forEach(element -> element.removePossibility(sudokuElement.getValue()));
    }

    public void removeColumnPossibilities(SudokuElement sudokuElement){
        board.getColumnElements(sudokuElement).stream()
                .filter(element -> element.getValue() == SudokuElement.EMPTY)
                .forEach(element -> element.removePossibility(sudokuElement.getValue()));
    }

    public void removeBoxPossibilities(SudokuElement sudokuElement){
        List<SudokuElement> occupiedList = board.getBoxElements(sudokuElement).stream()
                .filter(element -> element.getValue() != SudokuElement.EMPTY)
                .collect(Collectors.toList());
        board.getBoxElements(sudokuElement).stream()
                .filter(element -> element.getValue() == SudokuElement.EMPTY)
                .forEach(element -> occupiedList.forEach(occupied -> element.removePossibility(occupied.getValue())));
    }

    public void removeAllPossibilities(){
        List<SudokuElement> occupiedElements = this.board.getOccupiedElements();
        for(SudokuElement element: occupiedElements){
            removeColumnPossibilities(element);
            removeRowPossibilities(element);
            removeBoxPossibilities(element);
        }

    }

    public boolean validationCheck(){
        //EmptyElement check
        for(SudokuElement el: getBoard().getEmptyElements()){
            if (el.getPossibleValues().size()==0){
                return false;
            }
        }

        //Row check
        for (int row = 0; row<9; row++){
            List<SudokuElement> rowElements = board.getRowElements(board.getElement(row, 0));
            rowElements.add(board.getElement(row,0));
            Set<Integer> possibilities = rowElements.stream()
                    .flatMap(el -> el.getPossibleValues().stream())
                    .collect(Collectors.toSet());
            if(possibilities.size() != 9){
                return false;
            }
        }

        //Column check
        for (int col = 0; col<9; col++){
            List<SudokuElement> colElements = board.getColumnElements(board.getElement(0,col));
            colElements.add(board.getElement(0,col));
            Set<Integer> possibilities = colElements.stream()
                    .flatMap(el -> el.getPossibleValues().stream())
                    .collect(Collectors.toSet());
            if(possibilities.size() != 9){
                return false;
            }
        }

        //Box check
        for(int boxRowNr =0; boxRowNr<3; boxRowNr++){
            for(int boxColNr=0; boxColNr<3; boxColNr++){
                List<SudokuElement> boxElements = board.getBoxElements(board.getElement(boxRowNr, boxColNr));
                boxElements.add(board.getElement(boxRowNr, boxColNr));
                Set<Integer> possibilities = boxElements.stream()
                        .flatMap(el -> el.getPossibleValues().stream())
                        .collect(Collectors.toSet());
                if(possibilities.size() != 9){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solveNormally(){
        removeAllPossibilities();
        boolean areAnyNewElements = findElements();
        while (areAnyNewElements){
            removeAllPossibilities();
            areAnyNewElements = findElements();
        }
        return board.getOccupiedElements().size() == 81;
    }



    public boolean findElements(){

        boolean result = false;
        for(SudokuElement element: board.getEmptyElements()){
            for(Integer possibility: element.getPossibleValues()){

                List<Integer> allPossibilitiesInBox = board.getBoxElements(element).stream()
                        .filter(el -> el.getValue().equals(SudokuElement.EMPTY) && element != el)
                        .flatMap(el -> el.getPossibleValues().stream())
                        .collect(Collectors.toList());


                if(!allPossibilitiesInBox.contains(possibility) || element.getPossibleValues().size() == 1){
                    board.setElement(element.getRow(), element.getCol(), possibility);
                    removeAllPossibilities();
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public void newGame2(){
        board.setElement(1,0,1);
        board.setElement(0,3,7);
        board.setElement(2,3,4);
        board.setElement(2,4,3);
        board.setElement(2,6,2);
        board.setElement(4,3,5);
        board.setElement(4,5,9);
        board.setElement(3,8,6);
        board.setElement(5,6,4);
        board.setElement(5,7,1);
        board.setElement(5,8,8);
        board.setElement(7,2,2);
        board.setElement(8,1,4);
        board.setElement(6,4,8);
        board.setElement(6,5,1);
        board.setElement(7,7,5);
        board.setElement(8,6,3);
        removeAllPossibilities();
    }

    public void newGame(){
        board.setElement(0,1,2);
        board.setElement(0,3,5);
        board.setElement(0,5,1);
        board.setElement(0,7,9);
        board.setElement(1,0,8);
        board.setElement(1,3,2);
        board.setElement(1,5,3);
        board.setElement(1,8,6);
        board.setElement(2,1,3);
        board.setElement(2,4,6);
        board.setElement(2,7,7);
        board.setElement(3,2,1);
        board.setElement(3,6,6);
        board.setElement(4,0,5);
        board.setElement(4,1,4);
        board.setElement(4,7,1);
        board.setElement(4,8,9);
        board.setElement(5,2,2);
        board.setElement(5,6,7);
        board.setElement(6,1,9);
        board.setElement(6,4,3);
        board.setElement(6,7,8);
        board.setElement(7,0,2);
        board.setElement(7,3,8);
        board.setElement(7,5,4);
        board.setElement(7,8,7);
        board.setElement(7,8,7);
        board.setElement(8,1,1);
        board.setElement(8,3,9);
        board.setElement(8,5,7);
        board.setElement(8,7,6);
        removeAllPossibilities();
    }
}
