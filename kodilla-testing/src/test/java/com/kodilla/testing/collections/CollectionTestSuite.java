package com.kodilla.testing.collections;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.jupiter.api.*;

import java.util.*;

public class CollectionTestSuite {
    @BeforeEach
    public void before(){
        System.out.println("Test Case: begin");
    }
    @AfterEach
    public void after(){
        System.out.println("Test Case: end");
    }
    @DisplayName("When the list is empty, " +
            "then empty list should be generated")
    @Test
    void testOddNumbersExterminatorEmptyList(){
        //Given
        OddNumbersExterminator executedList = new OddNumbersExterminator();
        List<Integer> emptyList = new LinkedList<>();
        //When
        List<Integer> generatedList = executedList.exterminate(emptyList);
        //Then
        Assertions.assertEquals(new ArrayList<>(), generatedList);
    }
    @DisplayName("When the list is normal, " +
            "then new list, with only even numbers should be generated")
    @Test
    void testOddNumbersExterminatorNormalList(){
        //Given
        OddNumbersExterminator executedList = new OddNumbersExterminator();
        List<Integer> normalList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        //When
        List<Integer> generatedList = executedList.exterminate(normalList);
        //Then
        Assertions.assertEquals(Arrays.asList(2,4,6,8,10), generatedList);
    }
}