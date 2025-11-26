package org.example.todo.service;

import org.example.todo.TodoCollaborator;
import org.example.todo.TodoCollaboratorId;

import java.util.List;

public interface TodoCollaboratorService {
    TodoCollaborator create(TodoCollaborator collaborator);
    TodoCollaborator getById(TodoCollaboratorId id);
    List<TodoCollaborator> getAll();
    TodoCollaborator update(TodoCollaborator collaborator);
    void deleteById(TodoCollaboratorId id);
}
