package com.kodilla.sudoku;

import java.util.Random;

public class SudokuGenerator {

    public boolean isSolvable(SudokuBoard board){
        SudokuSolver solver = new SudokuSolver();
        SudokuGame game = new SudokuGame(board);
        try {
            solver.solve(game);
            if (game.isBoardFull()) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public SudokuBoard generateBoard() throws CloneNotSupportedException{
        boolean isGenerated = false;
        SudokuBoard board = null;
        SudokuBoard notSolved = null;
        while (!isGenerated) {
            try {
                board = extremeBoard();
                notSolved = board.deepCopy();
                isSolvable(board);
                if(board.getOccupiedElements().size()==81) {
                    isGenerated = true;
                }
            } catch (IndexOutOfBoundsException e) {

            }
        }
        return notSolved;
    }

    public SudokuBoard extremeBoard() throws CloneNotSupportedException{
        SudokuBoard board = new SudokuBoard();
        SudokuGame game = new SudokuGame(board);
        Random random = new Random();
        int elementQnt = 17 + random.nextInt(3);
        for(int elNr = 0; elNr <= elementQnt; elNr++){
            boolean isElementProper = false;
            while(!isElementProper){
                int row = random.nextInt(9);
                int col = random.nextInt(9);
                if(board.getElement(row,col).getValue() == SudokuElement.EMPTY) {
                    SudokuElement element = board.getElement(row, col);
                    board.setElement(row, col, element.getPossibleValues().get(random.nextInt(element.getPossibleValues().size())));
                    game.removeAllPossibilities();
                    isElementProper = true;
                }
            }
        }
        SudokuBoard notSolved = board.deepCopy();
        if (!isSolvable(board) || board.getOccupiedElements().size() != 81){
            extremeBoard();
        }
        return notSolved;
    }
}
