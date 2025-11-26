package org.example.todo.repository;

import org.example.todo.State;

public class StateRepositoryImpl extends AbstractHibernateRepository<State, Long> implements StateRepository {

    public StateRepositoryImpl() {
        super(State.class);
    }
}
