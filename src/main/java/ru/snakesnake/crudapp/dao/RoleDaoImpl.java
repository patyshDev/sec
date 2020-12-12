package ru.snakesnake.crudapp.dao;

import org.springframework.stereotype.Repository;
import ru.snakesnake.crudapp.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role getRoleByName(String name) {
        return entityManager
                .createQuery("select u from Role u where u.role =?1", Role.class)
                .setParameter(1, name)
                .getSingleResult();

    }
}
