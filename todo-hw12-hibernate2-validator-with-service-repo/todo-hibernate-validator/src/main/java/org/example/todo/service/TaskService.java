package org.example.todo.service;

import org.example.todo.Task;

import java.util.List;

public interface TaskService {
    Task create(Task task);
    Task getById(Long id);
    List<Task> getAll();
    Task update(Task task);
    void deleteById(Long id);
}
