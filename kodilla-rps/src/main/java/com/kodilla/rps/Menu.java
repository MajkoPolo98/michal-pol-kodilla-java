package com.kodilla.rps;

import java.util.Scanner;

public class Menu {
    public static void entryMainMenu(){
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        boolean exitMenu = false;
        String difficulty = "medium";
        while (!exitMenu){
            Menu.entryMainMenuText();
            String menuDecision = scanner.nextLine();
            if (menuDecision.equals("n")){
                System.out.println("Klawisze do gry:" +
                        "\n1 - Wyrzuca \"Kamień\"" +
                        "\n2 - Wyrzuca \"Papier\"" +
                        "\n3 - Wyrzuca \"Nożyce\"");
                boolean exitGame = false;
                while (!exitGame) {
                    System.out.println("No to gramy!");
                    String playerChoice = scanner.nextLine();
                    if (playerChoice.equals("x")){
                        boolean exitContinueGameMenu = false;
                        while (!exitContinueGameMenu) {
                            exitGame = true;
                            mainMenu();
                            String menuChoice = scanner.nextLine();
                            if (menuChoice.equals("c")) {
                                exitContinueGameMenu = true;
                                exitGame = false;
                            } else if (menuChoice.equals("n")) {
                                System.out.println("Czy na pewno chcesz rozpocząć nową grę? \nt/n");
                                boolean exitConfirmation = false;
                                while (!exitConfirmation) {
                                    String confirmation = scanner.nextLine();
                                    if (confirmation.equals("t")) {
                                        game.newGame();
                                        exitConfirmation = true;
                                        exitContinueGameMenu = true;
                                        exitGame = false;
                                    } else if (confirmation.equals("n")) {
                                        exitConfirmation = true;
                                        exitGame = false;
                                    } else {
                                        System.out.println("Niepoprawny klawisz");
                                    }
                                }
                            } else if (menuChoice.equals("x")) {
                                boolean exit = Menu.exitOption();
                                exitMenu = exit;
                                exitContinueGameMenu = exit;
                            } else if (menuChoice.equals("d")) {
                                difficulty = difficultyOption();
                            } else {
                                System.out.println("Niepoprawny klawisz");
                            }
                        }
                    } else if (Choices.choices().containsKey(playerChoice)) {
                        String computerKey = Computer.choice(playerChoice, difficulty);
                        String playerKey = Player.choice(playerChoice);
                        game.result(playerKey, computerKey);
                    } else {
                        System.out.println("Niepoprawny klawisz");
                    }

                }
            }
            else if (menuDecision.equals("x")){
                exitMenu = Menu.exitOption();
            } else {
                System.out.println("Zły klawisz");
            }
        }
    }
    public static void mainMenu(){
        Menu.entryMainMenuText();
        System.out.println("c - Kontynuuj grę");
    }
    public static boolean exitOption(){
        System.out.println("Czy na pewno chcesz zakończyć grę? \nt/n");
        boolean exitConfirmation = false;
        Scanner scanner = new Scanner(System.in);
        boolean result = true;
        while (!exitConfirmation) {
            String confirmation = scanner.nextLine();
            if (confirmation.equals("t")) {
                System.out.println("Trzymaj się!");
                exitConfirmation = true;
                result = true;
            } else if (confirmation.equals("n")){
                exitConfirmation = true;
                result = false;
            } else {
                System.out.println("Niepoprawny klawisz");
            }
        }
        return result;
    }
    public static void entryMainMenuText(){
        System.out.println("ROCK, PAPER, SCISSORS \nMenu Główne");
        System.out.println("n - Nowa gra");
        System.out.println("x - Koniec gry / Powrót do menu głównego");
        System.out.println("d - Ustawienia trudności");
    }
    public static String difficultyOption(){
        System.out.println("Wybierz poziom trudności: " +
                "\n1 -> łatwy (90% szans na nie przegranie w 1 turze)" +
                "\n2 -> średni (50% szans na nie przegranie w 1 turze)" +
                "\n3 -> trudny (10% szans na nie przegranie w 1 turze)");
        boolean exitConfirmation = false;
        Scanner scanner = new Scanner(System.in);
        boolean result = true;
        String difficulty = "medium";
        while (!exitConfirmation) {
            String confirmation = scanner.nextLine();
            if (confirmation.equals("1")) {
                exitConfirmation = true;
                difficulty = "easy";
            } else if (confirmation.equals("2")) {
                exitConfirmation = true;
                difficulty = "medium";
            } else if (confirmation.equals("3")){
                exitConfirmation = true;
                difficulty = "hard";
            } else {
                System.out.println("Niepoprawny klawisz");
            }
        }
        return difficulty;
    }
}
