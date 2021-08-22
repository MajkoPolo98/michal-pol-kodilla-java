package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayOperationsTestSuite {
    @Test
    void testGetAverage(){
        //Given
        int[] numberTable = {1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,3,3,3,3,3};
        //When
        double average = ArrayOperations.getAverage(numberTable);
        //Then
        assertEquals(3,average);
    }
    @Test
    void testGetAverageForEmptyList(){
        //Given
        int[] numberTable = {};
        //When
        double average = ArrayOperations.getAverage(numberTable);
        //Then
        assertEquals(0,average);
    }
}
