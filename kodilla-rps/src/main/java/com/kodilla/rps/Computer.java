package com.kodilla.rps;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Computer{

    public static String choice(String playerChoice, String difficulty){
        Random random = new Random();
        String computerChoice;
        int loseChance;
        if (difficulty.equals("hard")) {
            loseChance = 90;
        } else if (difficulty.equals("medium")) {
            loseChance = 100;
        } else {
            loseChance = 10;
        }
        int computerRandom = random.nextInt(100);
        if (computerRandom<=loseChance){    //Prawdopodobieństwo przegranej
            int index = random.nextInt(Game.loosingList(playerChoice).size());
            computerChoice = String.valueOf(Game.loosingList(playerChoice).get(index));
        } else {
            int index = random.nextInt(Game.winningList(playerChoice).size()+1);
            List<Integer> notLosingList = new LinkedList<>();
            notLosingList.add(Integer.parseInt(playerChoice));
            Game.winningList(playerChoice).stream().collect(Collectors.toCollection(() -> notLosingList));
            computerChoice = String.valueOf(notLosingList.get(index));
        }
        return computerChoice;
    }
}
