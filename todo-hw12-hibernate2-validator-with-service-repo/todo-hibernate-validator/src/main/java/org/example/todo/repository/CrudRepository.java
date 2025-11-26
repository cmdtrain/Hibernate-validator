package org.example.todo.repository;

import java.util.List;

public interface CrudRepository<T, ID> {
    T save(T entity);
    T findById(ID id);
    List<T> findAll();
    T update(T entity);
    void delete(T entity);
    void deleteById(ID id);
}
