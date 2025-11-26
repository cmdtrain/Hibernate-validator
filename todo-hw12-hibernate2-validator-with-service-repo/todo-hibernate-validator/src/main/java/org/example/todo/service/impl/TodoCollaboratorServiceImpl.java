package org.example.todo.service.impl;

import org.example.todo.TodoCollaborator;
import org.example.todo.TodoCollaboratorId;
import org.example.todo.repository.TodoCollaboratorRepository;
import org.example.todo.repository.TodoCollaboratorRepositoryImpl;
import org.example.todo.service.TodoCollaboratorService;

import java.util.List;

public class TodoCollaboratorServiceImpl implements TodoCollaboratorService {

    private final TodoCollaboratorRepository repository = new TodoCollaboratorRepositoryImpl();

    @Override
    public TodoCollaborator create(TodoCollaborator collaborator) {
        return repository.save(collaborator);
    }

    @Override
    public TodoCollaborator getById(TodoCollaboratorId id) {
        return repository.findById(id);
    }

    @Override
    public List<TodoCollaborator> getAll() {
        return repository.findAll();
    }

    @Override
    public TodoCollaborator update(TodoCollaborator collaborator) {
        return repository.update(collaborator);
    }

    @Override
    public void deleteById(TodoCollaboratorId id) {
        repository.deleteById(id);
    }
}
