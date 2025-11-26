package org.example.todo.repository;

import org.example.todo.ToDo;

public class ToDoRepositoryImpl extends AbstractHibernateRepository<ToDo, Long> implements ToDoRepository {

    public ToDoRepositoryImpl() {
        super(ToDo.class);
    }
}
