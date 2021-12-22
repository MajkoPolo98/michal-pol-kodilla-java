package com.kodilla.patterns2.observer.homework;


public class Student implements Observable{

    private Observer observer;
    private String studentName;

    public Student(Observer observer, String studentName) {
        this.observer = observer;
        this.studentName = studentName;
    }

    @Override
    public void registerObserver(Observer observer) {
        this.observer = observer;
    }

    @Override
    public void notifyObserver(Task task) {
        observer.update(task, this);
        System.out.println("Task added to the queue");
    }

    @Override
    public void removeObserver() {
        this.observer = null;
    }

    public Observer getObserver() {
        return observer;
    }

    public String getStudentName() {
        return studentName;
    }

    public void addTaskToQueue(Task task){
        observer.getTasksQueue().add(task);
        notifyObserver(task);
    }
}
