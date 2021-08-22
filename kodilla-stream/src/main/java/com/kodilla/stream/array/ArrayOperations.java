package com.kodilla.stream.array;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public interface ArrayOperations {
    static double getAverage(int[] numbers){
        IntStream stream = IntStream.range(0,numbers.length).map(n -> numbers[n]);
        if (stream.average().isPresent()){
            return stream.average().getAsDouble();
        } else {
            return 0;
        }
    }
}
