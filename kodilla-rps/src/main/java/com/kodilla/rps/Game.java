package com.kodilla.rps;


import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private int gameCount = 0;
    private int winCount = 0;

    public void result(String playerChoice, String computerChoice) {
        /*if ((playerChoice.equals("3") & computerChoice.equals("1")) ||
                (playerChoice.equals("1") && computerChoice.equals("2")) ||
                (playerChoice.equals("2") && computerChoice.equals("3"))) {*/
        if (loosingList(playerChoice).contains(Integer.parseInt(computerChoice))){
            //Lose
            System.out.println("Przegrana... Komputer wyrzucił: " + Choices.choices().get(computerChoice));

            gameCount += 1;
        } else if (playerChoice.equals(computerChoice)) {
            System.out.println("Remis!Komputer wyrzucił: " + Choices.choices().get(computerChoice));
            //Draw
        } else if (winningList(playerChoice).contains(Integer.parseInt(computerChoice))){
            //Win
            System.out.println("Wygrana! Komputer wyrzucił: " + Choices.choices().get(computerChoice));
            gameCount += 1;
            winCount += 1;
        } else if (!Choices.choices().containsKey(playerChoice)) {
            System.out.println("Nie rozumiem...");
        }
        System.out.println("Rozegranych gier: " + gameCount + ", w tym wygranych: " + winCount);
    }

    public void newGame() {
        winCount = 0;
        gameCount = 0;
    }

    public static List loosingList(String playerChoice){
        int loosingNumber = (Integer.parseInt(playerChoice) + 1);
        boolean whileBreaker = false;
        List<Integer> loosingList = new LinkedList<>();
        while (!whileBreaker) {
            loosingList.add(loosingNumber);
            loosingNumber += 2;
            if (loosingNumber >= Choices.choices().size()){
                loosingNumber -= Choices.choices().size();
            }
            if (loosingNumber == Integer.parseInt(playerChoice)){
                whileBreaker = true;
            }
        }
        return loosingList;
    }
    public static List winningList(String playerChoice){
        List<Integer> winningList = new LinkedList<>();
        winningList = Choices.choices().entrySet().stream().
                map(n -> n.getKey())
                .map(n -> Integer.parseInt(n))
                .filter(n -> !loosingList(playerChoice).contains(n))
                .filter(n -> n != Integer.parseInt(playerChoice))
                .collect(Collectors.toList());

        return winningList;
    }
}
