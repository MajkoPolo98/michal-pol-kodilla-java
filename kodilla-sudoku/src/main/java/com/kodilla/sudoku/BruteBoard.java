package com.kodilla.sudoku;

import lombok.Getter;

@Getter
public class BruteBoard {

    private SudokuGame game;
    private SudokuElement changedElement;

    public BruteBoard(SudokuGame game, SudokuElement changedElement) {
        this.game = game;
        this.changedElement = changedElement;
    }

    public int getChangedRow(){
        return changedElement.getRow();
    }

    public int getChangedCol(){
        return changedElement.getCol();
    }

    public SudokuBoard getBoard(){
        return game.getBoard();
    }

}

