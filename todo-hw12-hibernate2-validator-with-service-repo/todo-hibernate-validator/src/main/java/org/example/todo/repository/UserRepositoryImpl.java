package org.example.todo.repository;

import org.example.todo.User;
import org.hibernate.Session;

public class UserRepositoryImpl extends AbstractHibernateRepository<User, Long> implements UserRepository {

    public UserRepositoryImpl() {
        super(User.class);
    }

    @Override
    public User findByEmail(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from User u where u.email = :email", User.class)
                    .setParameter("email", email)
                    .uniqueResult();
        }
    }
}
