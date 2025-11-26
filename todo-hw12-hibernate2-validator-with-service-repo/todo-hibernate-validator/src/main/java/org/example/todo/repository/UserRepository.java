package org.example.todo.repository;

import org.example.todo.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
