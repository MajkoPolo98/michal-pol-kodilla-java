package com.kodilla.patterns2.observer.homework;

import java.util.LinkedList;

public interface Observer {
    void update(Task task, Student student);
    LinkedList<Task> getTasksQueue();
}
