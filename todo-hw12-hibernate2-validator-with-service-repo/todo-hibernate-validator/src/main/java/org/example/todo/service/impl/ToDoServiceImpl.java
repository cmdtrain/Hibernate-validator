package org.example.todo.service.impl;

import org.example.todo.ToDo;
import org.example.todo.repository.ToDoRepository;
import org.example.todo.repository.ToDoRepositoryImpl;
import org.example.todo.service.ToDoService;

import java.util.List;

public class ToDoServiceImpl implements ToDoService {

    private final ToDoRepository toDoRepository = new ToDoRepositoryImpl();

    @Override
    public ToDo create(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    @Override
    public ToDo getById(Long id) {
        return toDoRepository.findById(id);
    }

    @Override
    public List<ToDo> getAll() {
        return toDoRepository.findAll();
    }

    @Override
    public ToDo update(ToDo toDo) {
        return toDoRepository.update(toDo);
    }

    @Override
    public void deleteById(Long id) {
        toDoRepository.deleteById(id);
    }
}
