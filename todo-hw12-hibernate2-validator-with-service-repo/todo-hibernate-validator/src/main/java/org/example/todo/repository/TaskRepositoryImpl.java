package org.example.todo.repository;

import org.example.todo.Task;

public class TaskRepositoryImpl extends AbstractHibernateRepository<Task, Long> implements TaskRepository {

    public TaskRepositoryImpl() {
        super(Task.class);
    }
}
