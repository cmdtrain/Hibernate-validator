package org.example.todo.repository;

import org.example.todo.TodoCollaborator;
import org.example.todo.TodoCollaboratorId;

public class TodoCollaboratorRepositoryImpl extends AbstractHibernateRepository<TodoCollaborator, TodoCollaboratorId> implements TodoCollaboratorRepository {

    public TodoCollaboratorRepositoryImpl() {
        super(TodoCollaborator.class);
    }
}
