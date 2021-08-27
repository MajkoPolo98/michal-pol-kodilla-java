package com.kodilla.rps;

public class Player implements Choices{
    public static String choice(String decision){
        boolean finishWhile = false;
        while(!finishWhile) {
            if (Choices.choices().containsKey(decision)) {
                finishWhile = true;
            } else {
                System.out.println("Nie zrozumiałem wyboru");
                finishWhile = true;
            }
        }
        return decision;
    }

}
