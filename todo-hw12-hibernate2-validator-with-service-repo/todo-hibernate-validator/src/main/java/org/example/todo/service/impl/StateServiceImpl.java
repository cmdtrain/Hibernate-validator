package org.example.todo.service.impl;

import org.example.todo.State;
import org.example.todo.repository.StateRepository;
import org.example.todo.repository.StateRepositoryImpl;
import org.example.todo.service.StateService;

import java.util.List;

public class StateServiceImpl implements StateService {

    private final StateRepository stateRepository = new StateRepositoryImpl();

    @Override
    public State create(State state) {
        return stateRepository.save(state);
    }

    @Override
    public State getById(Long id) {
        return stateRepository.findById(id);
    }

    @Override
    public List<State> getAll() {
        return stateRepository.findAll();
    }

    @Override
    public State update(State state) {
        return stateRepository.update(state);
    }

    @Override
    public void deleteById(Long id) {
        stateRepository.deleteById(id);
    }
}
