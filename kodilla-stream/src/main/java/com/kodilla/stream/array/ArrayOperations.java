package com.kodilla.stream.array;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public interface ArrayOperations {
    static double getAverage(int[] numbers){
        IntStream stream = IntStream.range(0,numbers.length).map(n -> numbers[n]);
        return stream.average().getAsDouble();
    }
}
