package org.example.todo.service;

import org.example.todo.User;

import java.util.List;

public interface UserService {
    User create(User user);
    User getById(Long id);
    List<User> getAll();
    User update(User user);
    void deleteById(Long id);
    User getByEmail(String email);
}
