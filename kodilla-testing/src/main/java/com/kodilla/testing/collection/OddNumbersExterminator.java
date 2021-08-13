package com.kodilla.testing.collection;

import java.util.*;

public class OddNumbersExterminator {
    public List<Integer> exterminate(List<Integer> numbers) {
        List<Integer> exterminatedList = new ArrayList<>();
        for(Integer arg: numbers){
            if (arg%2 == 0){
                exterminatedList.add(arg);
            }
        }
        return exterminatedList;
    }
}
