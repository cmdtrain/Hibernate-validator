package org.example.todo.service.impl;

import org.example.todo.Task;
import org.example.todo.repository.TaskRepository;
import org.example.todo.repository.TaskRepositoryImpl;
import org.example.todo.service.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository = new TaskRepositoryImpl();

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task getById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task update(Task task) {
        return taskRepository.update(task);
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
}
