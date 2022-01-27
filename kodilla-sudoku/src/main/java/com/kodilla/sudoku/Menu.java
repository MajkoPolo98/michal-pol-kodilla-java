package com.kodilla.sudoku;

import java.util.Scanner;

public class Menu {
    public static void menu() throws CloneNotSupportedException{
        boolean exitGame = false;
        Game newGame = new Game();
        while (!exitGame) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("SUDOKU V1.0");
            System.out.println("1 - solve sudoku from the task");
            System.out.println("2 - generate random sudoku");
            System.out.println("3 - input your sudoku");
            System.out.println("X - end game");
            String menuDecision = scanner.nextLine();
            if (menuDecision.equals("1")) {
                newGame.gameFromTask();
            } else if (menuDecision.equals("2")) {
                newGame.getRandomGame();
            } else if (menuDecision.equals("3")) {
                newGame.makeOwnSudoku();
            } else if (menuDecision.equals("x")){
                exitGame = true;
            }
        }
    }

    public void mainMenu(){
        System.out.println("SUDOKU V1.0");
        System.out.println("1 - solve sudoku from the task");
        System.out.println("2 - generate random sudoku");
        System.out.println("3 - input your sudoku");
        System.out.println("X - end game");
    }
}
