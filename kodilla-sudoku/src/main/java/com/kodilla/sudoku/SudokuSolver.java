package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuSolver {

    private List<BruteBoard> tries = new ArrayList<>();
    private int iteration = 0;


    public SudokuBoard solve(SudokuGame game) throws CloneNotSupportedException {
        while (!game.isBoardFull() && iteration < 1000) {
            while(game.getBoard().getEmptyElements().size() == 0){
                while(game.getBoard().getEmptyElements().get(0).getPossibleValues().size() == 0) {
                    tries.remove(tries.size() - 1);
                    game.setBoard(tries.get(tries.size() - 1).getGame().getBoard());
                }
            }
            SudokuElement el = game.getBoard().getEmptyElements().get(0);
            this.iteration = iteration + 1;
            SudokuBoard copy = game.getBoard().deepCopy();
            SudokuGame testingGame = new SudokuGame(copy);
            BruteBoard bruteBoard = new BruteBoard(testingGame, el);
            tries.add(bruteBoard);
            game.removeAllPossibilities();
            game.getBoard().setElement(el.getRow(), el.getCol(), el.getPossibleValues().get(0));
            game.solveNormally();
            if (game.validationCheck()) {
                if (!game.isBoardFull()) {
                    game.getBoard().setElement(el.getRow(), el.getCol(), el.getPossibleValues().get(0));
                    game.removeAllPossibilities();
                }
            } else {
                BruteBoard lastTry = tries.get(tries.size() - 1);
                if (lastTry.getGame().getBoard()
                        .getElement(lastTry.getChangedRow(), lastTry.getChangedCol())
                        .getPossibleValues().size() == 1) {
                    tries.remove(tries.size() -1);
                    BruteBoard previousBoard = tries.get(tries.size() - 1);
                    previousBoard.getGame().getBoard()
                            .getElement(previousBoard.getChangedRow(), previousBoard.getChangedCol())
                            .getPossibleValues().remove(0);
                    game.setBoard(previousBoard.getGame().getBoard());
                } else {
                    tries.remove(tries.size() - 1);
                    lastTry.getBoard()
                            .getElement(lastTry.getChangedRow(),lastTry.getChangedCol())
                            .getPossibleValues().remove(0);
                    game.setBoard(lastTry.getGame().getBoard());
                }
            }
        }
        return game.getBoard();
    }

    public void simpleExchange(){
        tries.remove(tries.size() - 1);
        BruteBoard lastTry = tries.get(tries.size()-1);
        lastTry.getGame().getBoard()
                .getElement(lastTry.getChangedRow(),lastTry.getChangedCol())
                .getPossibleValues().remove(0);
    }

    public void backStep(int stepQty){
        for(int i=0; i<stepQty; i++) {
            tries.remove(tries.size()-1);
        }
        int index = tries.size()-1;
        BruteBoard lastTry = tries.get(index);
        tries.get(index).getGame().getBoard()
                .getElement(lastTry.getChangedRow(),lastTry.getChangedCol())
                .getPossibleValues().remove(0);
    }

}
