package org.example.todo.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;
import java.util.function.Function;

public abstract class AbstractHibernateRepository<T, ID extends Serializable> implements CrudRepository<T, ID> {

    private final Class<T> entityClass;

    protected AbstractHibernateRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T save(T entity) {
        return executeInTransaction(session -> {
            session.save(entity);
            return entity;
        });
    }

    @Override
    public T findById(ID id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(entityClass, id);
        }
    }

    @Override
    public List<T> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String query = "from " + entityClass.getSimpleName();
            return session.createQuery(query, entityClass).getResultList();
        }
    }

    @Override
    public T update(T entity) {
        return executeInTransaction(session -> {
            session.update(entity);
            return entity;
        });
    }

    @Override
    public void delete(T entity) {
        executeInTransaction(session -> {
            session.delete(entity);
            return null;
        });
    }

    @Override
    public void deleteById(ID id) {
        executeInTransaction(session -> {
            T entity = session.get(entityClass, id);
            if (entity != null) {
                session.delete(entity);
            }
            return null;
        });
    }

    private <R> R executeInTransaction(Function<Session, R> function) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            R result = function.apply(session);
            transaction.commit();
            return result;
        } catch (RuntimeException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }
}
