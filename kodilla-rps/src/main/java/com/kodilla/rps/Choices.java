package com.kodilla.rps;

import java.util.HashMap;
import java.util.Map;

public interface Choices {
    static Map<String, String> choices(){
        Map<String, String> choices = new HashMap<>();
        choices.put("1", "Kamień");
        choices.put("2", "Papier");
        choices.put("3", "Nożyce"); //Można dopisywać kolejne 2 wariantów - byle następny bił poprzedni i następujący 2 numer przed nim.
        //choices.put("4", "Bije 3 i 1");
        //choices.put("5", "Bije 4 i 2");
        return choices;
    }

}
