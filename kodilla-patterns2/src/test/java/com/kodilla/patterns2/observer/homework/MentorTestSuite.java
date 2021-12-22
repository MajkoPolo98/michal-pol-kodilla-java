package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MentorTestSuite {

    @Test
    public void testQueue(){
        //Given
        Task taskOne = new Task("First Task");
        Task taskTwo = new Task("Second Task");
        Task tashThree = new Task("Third Task");


        Mentor mentor1 = new Mentor("MenThorOne");
        Mentor mentor2 = new Mentor("MenThorTwo");

        Student student1 = new Student(mentor1, "One");
        Student student2 = new Student(mentor1, "Two");
        Student student3 = new Student(mentor2, "Three");
        Student student4 = new Student(mentor2, "Four");
        Student student5 = new Student(mentor1, "Five");


        //When
        student1.addTaskToQueue(taskOne);
        student2.addTaskToQueue(taskTwo);
        student3.addTaskToQueue(tashThree);
        student4.addTaskToQueue(taskOne);
        student5.addTaskToQueue(taskTwo);

        //Then
        Assertions.assertEquals(3,mentor1.getTasksQueue().size());
        Assertions.assertEquals(2,mentor2.getTasksQueue().size());
    }

}