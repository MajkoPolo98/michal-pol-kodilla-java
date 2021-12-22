package com.kodilla.patterns2.observer.homework;

import java.util.LinkedList;

public class Mentor implements Observer{

    private String mentorName;
    private LinkedList<Task> tasksQueue = new LinkedList<>();

    public Mentor(String mentorName) {
        this.mentorName = mentorName;
    }

    @Override
    public void update(Task task, Student student) {
        System.out.println("New task: " + task.getTaskName() + " from student: " + student.getStudentName());
    }

    @Override
    public LinkedList<Task> getTasksQueue(){
        return tasksQueue;
    }


}
