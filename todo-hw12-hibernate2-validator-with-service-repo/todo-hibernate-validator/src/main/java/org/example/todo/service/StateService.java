package org.example.todo.service;

import org.example.todo.State;

import java.util.List;

public interface StateService {
    State create(State state);
    State getById(Long id);
    List<State> getAll();
    State update(State state);
    void deleteById(Long id);
}
