package org.example.todo.service;

import org.example.todo.ToDo;

import java.util.List;

public interface ToDoService {
    ToDo create(ToDo toDo);
    ToDo getById(Long id);
    List<ToDo> getAll();
    ToDo update(ToDo toDo);
    void deleteById(Long id);
}
