package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskFactoryTestSuite {

    @Test
    void testDrivingTask(){
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task driving = factory.makeTask(TaskFactory.DRIVING);
        //Then
        assertEquals("driving", driving.getTaskName());
        assertEquals(false, driving.isTaskExecuted());
        driving.executeTask();
        assertEquals(true, driving.isTaskExecuted());
    }

    @Test
    void testPaintingTask(){
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task painting = factory.makeTask(TaskFactory.PAINTING);
        //Then
        assertEquals("painting", painting.getTaskName());
        assertEquals(false, painting.isTaskExecuted());
        painting.executeTask();
        assertEquals(true, painting.isTaskExecuted());
    }

    @Test
    void testShoppingTask(){
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shopping = factory.makeTask(TaskFactory.SHOPPING);
        //Then
        assertEquals("shopping", shopping.getTaskName());
        assertEquals(false, shopping.isTaskExecuted());
        shopping.executeTask();
        assertEquals(true, shopping.isTaskExecuted());
    }
}
