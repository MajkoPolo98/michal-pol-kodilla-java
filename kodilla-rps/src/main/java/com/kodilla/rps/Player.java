package com.kodilla.rps;

import java.util.List;
import java.util.Scanner;

public class Player implements Choices{
    public static String choice(String decision){
        boolean finishWhile = false;
        while(!finishWhile) {
            if (decision.equals("1") || decision.equals("2") || decision.equals("3")) {
                finishWhile = true;
            } else {
                System.out.println("Nie zrozumiałem wyboru");
                finishWhile = true;
            }
        }
        return decision;
    }

}
