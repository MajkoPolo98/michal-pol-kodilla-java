package com.kodilla.sudoku;

import java.util.Scanner;

public class Game {
    public void gameFromTask() throws CloneNotSupportedException{
        SudokuBoard board = new SudokuBoard();
        SudokuGame game = new SudokuGame(board);
        game.newGame();
        setNewElement(game);
    }

    public void getRandomGame() throws CloneNotSupportedException{
        SudokuGenerator generator = new SudokuGenerator();
        SudokuBoard board = generator.generateBoard();
        SudokuGame game = new SudokuGame(board);
        setNewElement(game);
    }

    public void makeOwnSudoku() throws CloneNotSupportedException{
        SudokuBoard board = new SudokuBoard();
        SudokuGame game = new SudokuGame(board);
        setNewElement(game);
    }

    public void setNewElement(SudokuGame game) throws CloneNotSupportedException{
        Scanner scanner = new Scanner(System.in);
        SudokuBoard playableBoard = game.getBoard();
        SudokuBoard entryBoard = playableBoard.deepCopy();
        boolean exitToMenu = false;
        while(!exitToMenu) {
            System.out.println(playableBoard);
            if(playableBoard.getOccupiedElements().size() != 81) {
                System.out.println("Please input coordinates and value (ROW,COL,VAL)");
                System.out.println("To solve type: solve");
            }
            System.out.println("To exit to menu type: x");
            String input = scanner.nextLine();
            input.toLowerCase();
            String[] coordinates = input.replace(" ", "").split(",");
            try {
                Integer row = Integer.valueOf(coordinates[0]);
                Integer col = Integer.valueOf(coordinates[1]);
                Integer val = Integer.valueOf(coordinates[2]);
                System.out.println(row + "," + col + "," + val);
                if (entryBoard.getElement(row, col).getValue() != SudokuElement.EMPTY) {
                    System.out.println("You cannot change initial numbers");
                } else {
                    if (0 <= row && row < 9 && 0 <= col && col < 9) {
                        playableBoard.setElement(row, col, val);
                    }
                }
            } catch (NumberFormatException e){
                if(input.equals("x")){
                    exitToMenu = true;
                } else if (input.equals("solve")) {
                    SudokuSolver solver = new SudokuSolver();
                    solver.solve(game);
                } else {
                    System.out.println(input);
                    System.out.println("Not correct input");
                }
            }
        }

    }
}
