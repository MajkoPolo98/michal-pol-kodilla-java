package com.kodilla.rps;

import java.util.HashMap;
import java.util.Map;

public interface Choices {
    static Map<String, String> choices(){
        Map<String, String> choices = new HashMap<>();
        choices.put("1", "Kamień");
        choices.put("2", "Papier");
        choices.put("3", "Nożyce"); //Można dopisywać kolejne 2 wariantów - byle następny bił poprzedni tj. następna dodana rzecz bije papier
        return choices;
    }

}
