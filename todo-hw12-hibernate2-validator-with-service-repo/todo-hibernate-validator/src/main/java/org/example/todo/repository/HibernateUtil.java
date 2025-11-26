package org.example.todo.repository;

import org.example.todo.State;
import org.example.todo.Task;
import org.example.todo.ToDo;
import org.example.todo.TodoCollaborator;
import org.example.todo.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private HibernateUtil() {
    }

    private static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(State.class);
        configuration.addAnnotatedClass(Task.class);
        configuration.addAnnotatedClass(ToDo.class);
        configuration.addAnnotatedClass(TodoCollaborator.class);
        return configuration.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
