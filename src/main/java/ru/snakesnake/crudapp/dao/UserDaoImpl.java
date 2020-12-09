package ru.snakesnake.crudapp.dao;

import org.springframework.stereotype.Repository;
import ru.snakesnake.crudapp.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void removeUser(long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    @SuppressWarnings("unchecked")
    public User getUserById(long id) {
        return entityManager
                .createQuery("select u from User u where u.id =?1", User.class)
                .setParameter(1, id)
                .getSingleResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        Query query = entityManager.createQuery("from User");
        return query.getResultList();
    }
    @Override
    public User getUserByUsername(String username) {
        return entityManager
                .createQuery("select u from User u where u.username =?1", User.class)
                .setParameter(1, username)
                .getSingleResult();
    }

}

